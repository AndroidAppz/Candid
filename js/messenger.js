/**
 * Front-end component of the system-wide messaging service.
 *
 * This will display messages from the backend on load, and will also
 * expose methods which can be used to display messages during runtime.
 */
!function (g, gm) {
  var m = {
    msgs: [],
    pmNotificationClosed: undefined,
    wrapperDom: '<div class="pm-persistent-notification-container"></div>' +
      '<div class="pm-global-notification-container"></div>',
    messageDom: function (id, className, message) {
      return ['<div id="', id, '"><div class="pm-global-notification ', className, '">', message, '<div class="pm-global-notification-close">×</div></div></div>'].join('')
    },

    messageTypes: {
      'success': 'pm-global-success',
      'warning': 'pm-global-warning',
      'error': 'pm-global-error',
      'notify': 'pm-global-notify',
      'default': 'pm-global-error'
    },

    /**
     * Shows a single message
     */
    show: function (message, index) {
      var msgWrapper = document.getElementsByClassName('pm-global-notification-container')[0],
        persistentWrapper = document.getElementsByClassName('pm-persistent-notification-container')[0],
        msgClass,
        msgId;

      if(message.body) {
        // Extract the type of message, fallback to an error on failure
        msgClass = m.extractClass(message);
        // Generate an ID so we can hide this message after an interval
        msgId = ['mid_', new Date().getTime()].join('');

        if (message.persist) {
          msgClass += ' pm-message-persistent';
          persistentWrapper.insertAdjacentHTML('beforeend', m.messageDom(msgId, msgClass, message.body));
        }
        else {
          // Show the message and schedule automatic dismissal
          msgWrapper.insertAdjacentHTML('beforeend', m.messageDom(msgId, msgClass, message.body));
          m.assignTimeout(msgId);
        }
      }
    },

    /**
     * Show all queued message at once and then clear the array
     */
    showAll: function () {
      m.msgs.forEach(m.show);
      m.msgs.splice(0);
    },

    /**
     * Queues a message to show later
     */
    queue: function (message) {
      m.msgs.push(message);
    },

    /**
     * This function will extract the type and return the class to be injected into the
     * message element.
     */
    extractClass: function (message) {
      return m.messageTypes[message.type] || m.messageTypes['default'];
    },

    /**
     * When a new message element is injected, this function sets a timeout
     * to automatically dismiss the message after some time.
     */
    assignTimeout: function (id) {
      setTimeout(function () {
        var thisEl = document.getElementById(id);

        thisEl && thisEl.parentElement.removeChild(thisEl);
      }, 5000);
    },

    /**
     * Attaches an event handler to an element
     */
    attachEventHandler: function (el, event, handler) {
      return el && el.addEventListener(event, handler);
    },

    /**
     * Creates a custom event type
     */
    createCustomEvent: function (name, bubbles, cancellable) {
      var ev = document.createEvent('Event');
      ev.initEvent(name, bubbles, cancellable);

      return ev;
    },

    /**
     * Removes a message element when a child element with a pm-global-notification-close
     * class is clicked.
     */
    closeMessageHandler: function (e) {
      var notification;

      if(e.target.className.indexOf('pm-global-notification-close') > -1) {
        notification = e.target.parentElement.parentElement;
        notification.parentElement.removeChild(notification);
        document.dispatchEvent(m.pmNotificationClosed);
      }
    },

    /**
     * Injects wrapper DOM
     */
    bootstrap: function (cb) {
      document.body.insertAdjacentHTML('beforeend', m.wrapperDom);
      m.attachEventHandler(document.body, 'click', m.closeMessageHandler);

      // Create a custom event to emit when a notification is closed
      m.pmNotificationClosed = m.createCustomEvent('pm-notification-closed', true, true);

      typeof cb === 'function' && cb();
    }
  };

  // Process any cached queueMessage commands
  g.messenger.messageCache.length && g.messenger.messageCache.forEach(function(cached) {
    m.queue.apply(null, cached);
  });

  // Expose the messenger object
  g[gm] = m;
}(window, 'messenger');
