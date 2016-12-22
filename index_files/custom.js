/* globals $,document,window,Handlebars,Prism,_,RegExp */
/* jshint latedef: nofunc */
var initialJson,
  collectionJson,
  environmentMapping = {},
  envLabel,
  toc = {},
  privateDocUrl,
  collectionVariantsExist = false,
  expandables = {
    '.api-information table': {
      'maxHeight': 500,
      'wrapper': '<div class=\'md-table expandable\'><div class=\'md-table-container expand-content\'></div></div>'
    },
    '.api-information pre': {
      'maxHeight': 300,
      'wrapper': '<div class=\'md-pre expandable\'><div class=\'expand-content\'></div></div>'
    },
    '.examples pre': {
      'maxHeight': 300,
      'wrapper': '<div class=\'md-pre-dark expandable dark-expandable\'><div class=\'expand-content\'></div></div>'
    },
    'default': {
      'maxHeight': 200,
      'wrapper': '<div class=\'expandable\'><div class=\'expand-content\'></div></div>'
    }
  };

$(document).ready(bootstrapView);

function bootstrapView () {
  var collection;

  try {
    initialJson = getInitialJson();
    collectionJson = getInitialCollectionJson();
    collection = _.cloneDeep(collectionJson);
    buildEnvironmentMapping(initialJson.environments);
    attachSidebarHandlers();
  }
  catch (e) {
    console.error(e);
  }

  //TODO- move this to separate file
  $('.shared-environment-dropdown li').on('click', function () {
    $('.environment').text($(this).text());
    $('#environment_template_id').val($(this).data('environment-id'));
    $('#environment_owner').val($(this).data('owner'));
  });

  if (collectionJson && collectionJson.info.public) {
    var environmentData = environmentMapping[$('.environment').data('environment-id')];

    collection = substituteObjectVars(collectionJson, environmentData);

    // Variable needed by GTM
    envLabel = $('.environment').text() === 'No Environment' ? 'no-env' : 'env';
    privateDocUrl = collectionJson.info.privateUrl;
  }

  messenger.bootstrap(function () {
    // Display any queued messages
    messenger.showAll();
  });

  addLoader();
  applyBranding();
  populateDataIntoTemplate('doc-sidebar', collection);
  wrapExpandables();
  attachHandlers();
  buildToC();
  showLiveDocBanner();
  adjustDocumentPadding($('.pm-message-persistent'));

  scrollToHash();
}

function addLoader () {
  Pace.start();
}

function applyBranding () {
  $identity = $('.branded-logo');
  $identity
    .css('background-image', 'url("' + $identity.data('identity-href') + '")')
    .removeData('identity-href');
}

// Wrap large expandable elements in a div, which will allow us to limit the height/width
// of the element and allow for click-to-expand behavior
function wrapExpandables (sel) {
  var scope = _.omit(expandables, 'default'),
    defaults = expandables.default;

  if(sel && expandables[sel]) {
    scope = {};
    scope[sel] = expandables[sel];
  }

  _.forOwn(scope, function (meta, selector) {
    _.forEach($(selector), function(el, selector) {
      var $this = $(el),
        elHeight = $this.outerHeight(),
        elWidth = $this.outerWidth(),
        childWidth = $this.children().outerWidth(),
        wrapper = meta.wrapper || defaults.wrapper,
        maxHeight = meta.maxHeight || defaults.maxHeight;

      (elHeight > maxHeight || childWidth > elWidth) && $this.wrap(wrapper);
    });
  });
}

function enforceTableWidth () {
  $('.md-table-container').each(function(index, tableContainer) {
    var columns = tableContainer.querySelector('tr').cells.length;
    $(this).css('width', columns * 150);
  });
}

function populateDataIntoTemplate (templateName, data) {
  var template = Handlebars.templates[templateName],
    $docs = $('#doc-body');

  $docs.html(template(data));

  prepareView();

  // Set dynamic width of the table in the next tick when the tables are rendered.
  setTimeout(function() {
    enforceTableWidth();
  });

  // Adding event listener for responses dropdown menus for all requests
  $('.response-name .dropdown-menu li').click(changeResponse);
}

function prepareView () {
  beautifyResponse();

  // Displaying the first request and response by default for all requests.
  displayDefaultRequests();

  displayDefaultResponses();

  modifyDummyElementHeight();

  bindScrollHandler();

  scrollToHash();
}

function scrollToHash () {
  var $target = $(window.location.hash);
  $target.length && $('body').scrollTop($target.offset().top);
}

function attachHandlers () {
  // Adding event listener for responses dropdown menus for all requests
  $('.response-name li').click(changeResponse);

  // Adding event listener for change in language.
  $('.language_dropdown').on('click', '.dropdown-menu-item', changeAllRequests);

  $(window).on('resize', function () {
    modifyDummyElementHeight();
  });

  $('.expandable').on('click', showInModal);

  $('.shared-environment-dropdown li').on('click', function () {
    setEnvironmentMeta($(this));
  });

  $('.environment-dropdown li').on('click', function () {
    var environmentId = $(this).data('environment-id'),
      selectedEnvironmentId = $('.environment').data('environment-id'),
      collectionJson;

    if (environmentId === selectedEnvironmentId) {
      return ;
    }
    // This indicates the user chose No Environment
    else if (environmentId === 0){
      collectionJson = getInitialCollectionJson();
      setEnvironmentMeta($(this));
      populateDataIntoTemplate('doc-sidebar', collectionJson);
      attachHandlers();
      return;
    }
    else {
      displayCollectionWithEnvironment.bind($(this))(environmentId);
    }
  });

  bindPublishButtonHandler();

  $('#unpublish_button').on('click', function () {
    var $form = $('#unpublish_collection');
    $form.submit();
  });

  // attaching events to capture clicks on clickboard elements. These elements are used to copy text.
  new Clipboard('.copy-text');
  var requestClipboard = new Clipboard('.copy-request');

  requestClipboard.on('success', function(e) {
    $(e.trigger).addClass('copied');

    setTimeout(function() {
      $(e.trigger).removeClass('copied');
    }, 1000)

    // Remove comments to prevent selecting copied text
    e.clearSelection();
  })

  $('.settings-toggle').on('click', function () {
    $('#mobile-controls').toggleClass('is-visible');
  });
}

function attachSidebarHandlers () {
  $('.folder .toggle-folder-collapse').on('click', toggleFolderState);

  $('.folder-link>a').on('click', activateFolder);

  // Simulating clicking on folder name , when folder icon is clicked.
  $('.pm-doc-sprite-folder').on('click', function () {
    $(this).siblings('.folder-link').find('a')[0].click();
  });

  $('body').scrollspy({target: '#navbar-example'});

  $(window).on('activate.bs.scrollspy', function () {
    var activeElement = $('.nav-link[href="' + arguments[1].relatedTarget + '"]');
    scrollIntoView(activeElement);
    highlightParentFolder(activeElement);
  });

  // Menu toggle button on tablet and mobile.
  $('body')
    .on('click', '#menu-toggle', function () {
      $('body').toggleClass('nav-open');
    })
    .on('click', '.nav a', function () {
      // Do this inside a setTimeout so the hash has a chance to update
      setTimeout(function () {
        $('body').removeClass('nav-open');
        scrollToHash();
      }, 0);
    });
}

function activateFolder () {
  var $folderLink = $(this),
    // parent li with class folder
    $folderLi = $(this).closest('.folder'),
    allFolders = $('.folder-link>a');

  if ($folderLi.hasClass('open')) {
    $folderLink.hasClass('active') && collapseFolder($folderLi);
  }
  else {
    allFolders.removeClass('active-folder');
    expandFolder($folderLi);
  }
}

function bindScrollHandler () {
  $(window).on('scroll resize pm-notification-closed', adjustDocumentPadding.bind(this, $('.pm-message-persistent')));
}

function adjustDocumentPadding ($persistentMessage) {
  var scrollTop = $(window).scrollTop(),
    $persistentWrap = $persistentMessage.parents('.pm-persistent-notification-container'),
    headerHeight = 70,
    persistentHeight = 0;

  $persistentMessage && $persistentMessage.length && (persistentHeight = $persistentMessage.outerHeight());
  if(scrollTop > headerHeight) {
    scrollTop = headerHeight;
    $persistentWrap.addClass('is-fixed');
  } else {
    $persistentWrap.removeClass('is-fixed');
  }

  $('.sidebar').css('padding-top', (headerHeight + persistentHeight - scrollTop) + 'px');
  $('.container-fluid').css('padding-top', persistentHeight + 'px');
}

function displayCollectionWithEnvironment (environmentId) {
  var environmentData = environmentMapping[environmentId],
    collectionWithEnvironment;

  setEnvironmentMeta($(this));
  collectionWithEnvironment = substituteObjectVars(collectionJson, environmentData);

  if (collectionVariantsExist) {
    // Fake collection load
    Pace.restart();
  }

  populateDataIntoTemplate('doc-sidebar', collectionWithEnvironment);
  wrapExpandables();
  attachHandlers();
}

function setEnvironmentMeta ($selectedEnvironment) {
  $('.environment').text($selectedEnvironment.text());
  $('.environment').data('environment-id', $selectedEnvironment.data('environment-id'));
}

function getInitialCollectionJson () {
  // The initial json is stored in the dom and is populated into the dom on first load.
  return initialJson.collection;
}

function getInitialJson () {
  var $jsonElement = $('#data'),
    text = $jsonElement.attr('data-meta');
    initialJson;

  try {
    initialJson = JSON.parse(decodeText(text));
  }
  catch (e) {
    initialJson = JSON.parse(text);
  }

  $('#data').remove();
  return initialJson;
}

function decodeText (text) {
  var decodedText = text;
  try {
    decodedText = decodeURI(text);
  }
  catch (e) {
  }
  return decodedText;
}

function scrollIntoView ($activeElement) {
  var $ancestorFolder,
    sidebarEl = $('.sidebar').get(0),
    sidebarIsScrollable = sidebarEl.scrollHeight > sidebarEl.clientHeight;

  if (sidebarIsScrollable) {
    $ancestorFolder = $activeElement.closest('.folder').find('.folder-link a');

    if (($ancestorFolder.length === 0) ||
        $activeElement.closest('.folder').hasClass('open')) {
      $activeElement.scrollIntoView(false);
    } else if ($ancestorFolder.length) {
      $ancestorFolder.scrollIntoView(false);
    }
  }
}

function highlightParentFolder ($activeElement) {
  var isFolder = $activeElement.parent().hasClass('folder-link'),
    $ancestorFolder;

  // If the active element is a folder , then it has no ancestor folder. We just need to remove active-folder
  // class from already highlighted folders if any.
  if (isFolder) {
    $('.folder-link a').removeClass('active-folder');
    return;
  }

  $ancestorFolder = $activeElement.closest('.folder').find('.folder-link a');

  // This means the request is outside any folder, hence we don't need to highlight parent folder.
  if (!$ancestorFolder ) { return; }

  // If ancestor folder was already highlighted.
  if ($ancestorFolder.hasClass('active-folder')) {
    return;
  }
  // If request has an ancestor folder and its not already highlighted then
  // highlight it and remove highlighting from all other folders.
  $('.folder-link a').removeClass('active-folder');
  $ancestorFolder.addClass('active-folder');
}

function showInModal () {
  var contentContainer = $(this).find('.expand-content');
  var modalContent = contentContainer.html();
  var width = contentContainer.css('width');

  $('#rawBodyModal')
    .addClass('white-background')
    .modal()
    .find('.modal-body')
      .html(modalContent)
      .css('width', width || 'auto');
}

function collapseFolder ($folder) {
  $folder.find('ul').removeClass('display-requests');
  $folder.removeClass('open');
  return true;
}

function expandFolder ($folder) {
  $folder.find('ul').addClass('display-requests');
  $folder.addClass('open');
  return true;
}

function toggleFolderState () {
  var $thisFolder = $(this).closest('.folder');
  $thisFolder.hasClass('open') && collapseFolder($thisFolder) || expandFolder($thisFolder);
}

/* We have a dummy documentation element at the end of the last request ,
 * so that the last request can be highlighted on click
 */
function modifyDummyElementHeight () {
  var rows = $('.row.row-no-padding.row-eq-height'),
    $secondLastDoc = $(rows[rows.length - 2]),
    offset = parseInt($('.info').data('offset')) || 0;
  $secondLastDoc.find('.col-xs-12').css('border-bottom', '0px');
  // height of dummy element is enough for the last element to be highlited.
  $('.dummy').height($(window).height() - $secondLastDoc.height() - offset + 10);
}

// Method which parses response text strings and populates them.
function beautifyResponse () {
  var responseText;
  _.forEach($('.formatted-responses'), function (responseDiv) {
    responseDiv = $(responseDiv);
    responseText = responseDiv.text();
    try {
      responseText = JSON.parse(responseText);
      responseText = JSON.stringify(responseText, null, 2);
    }
    catch (e) {
    }
    populateSnippet(responseDiv, responseText);
  });
  Prism.highlightAll();
}

function updateLanguage (langPreference) {
  $('.active-lang').text(langPreference);
  $('.formatted-requests[data-lang="' + langPreference + '"][data-id$="_0"]').show();
}

function displayDefaultRequests () {
  var langPreference = $('.active-lang:visible').text();

  try {
    langPreference = localStorage.getItem('lang_preference') || langPreference;
  }
  catch (err) {
    console.log("Failed to get from localstorage with error => ", err)
  }

  updateLanguage(langPreference);
}

function displayDefaultResponses () {
  $('.formatted-responses[data-id$="_0"]').show();
}

// This changes the request and response for one particular request on selection from the dropdown for request name.
function changeResponse () {
  // Request info has info related to response number and response name has the id of request.
  var request_info = $(this).data('request-info'),
    request_name = $(this).data('request-name');
  // Hiding all responses and requests for this request
  $('.formatted-requests[data-id^=' + request_name + ']').hide();
  $('.formatted-responses[data-id^=' + request_name + ']').hide();
  // Selectively showing only one request and response.
  $('.formatted-requests[data-id=' + request_info + '][data-lang="' + $('.active-lang').text()+ '"]').show();
  $('.formatted-responses[data-id=' + request_info + ']').show();
  // Changing the text of the selected box.
  $('#' + request_name + '_dropdown').html($(this).text());
}

// Change all request snippets based on the new language selected.
function changeAllRequests () {
  var selected_lang = $(this).text(),
    request_reference,
    visible_requests = $('.formatted-requests:visible');

  $('.active-lang').text(selected_lang);

  try {
    localStorage.setItem('lang_preference', selected_lang);
  }
  catch (err) {
    console.log("Failed to set localStorage with error => ", err);
  }

  $('.formatted-requests').hide();

  _.forEach(visible_requests, function (visibleRequest) {
    setTimeout(function () {
      request_reference = $(visibleRequest).data('id');
      $('.formatted-requests[data-lang="' + selected_lang + '"][data-id="' + request_reference + '"]').show();
    }, 0);
  });
  Prism.highlightAll();
}

function populateSnippet (divElement, snippet) {
  divElement.html('<pre><code class="language-javascript"></code></pre>');
  divElement.find('code').text(snippet);
}

// Method to get value for a query parameter using theri name
// Source - http://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
function getParameterByName (name) {
  var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
  return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}

function buildEnvironmentMapping (environments) {
  _.forEach(environments, function (env) {
    environmentMapping[env.id] = convertArrayToFlatObject(env.values);
  });
}

function convertArrayToFlatObject (envValues) {
  return _.reduce(envValues, function (result, envVariable) {
    (result[envVariable.key] = envVariable.value);
    return result;
  }, {});
}

function substituteObjectVars (object, environment) {
  var self = this;
  var substitutedData = object;

  if (typeof object === "boolean") return object;

  substitutedData = _.reduce(object, function (accumulator, value, key) {
    var subsKey = self.substituteVars(key, environment),
      subsValue = value;

    if (_.isString(value)) {
      subsValue = self.substituteVars(value, environment);
    }
    else if (_.isArray(value)) {
      subsValue = _.map(value, function (eachValue) {
        return _.isString(eachValue) ?
          self.substituteVars(eachValue, environment) : self.substituteObjectVars(eachValue, environment);
      });
    }
    else {
      subsValue = self.substituteObjectVars(value, environment);
    }
    accumulator[subsKey] = subsValue;
    return accumulator;
  }, {});
  collectionVariantsExist = !_.isEqual(object, substitutedData) || collectionVariantsExist;
  return substitutedData;
}

function substituteVars (template, variables) {
  //don't touch the template if it is not a string
  if (typeof template !== 'string') {
    return template;
  }
  // if view is not a valid object, assume it is an empty object which effectively removes all variable assignments
  if (typeof variables !== 'object' || variables === null) {
    variables = {};
  }
  return template.replace(/\{?\{\{\s*(.*?)\s*\}\}\}?/g, function (match, varName) {
    var value = variables[varName];
    return (value && value.toString && typeof value !== 'function') ? value.toString() : match;
  });
}

function buildToC () {
  var $source = $('.collection-description h1');

  $source.each(function (i, heading) {
    var raw = $(heading).html(),
      slugOpts = {
        lower: true
      },
      id = slug(raw, slugOpts),
      template = Handlebars.templates['toc-item'],
      $tocWrapper = $('.toc ul'),
      data = {},
      html;

    !id && (id = 'section');

    // If the id has already been assigned, increment its index by one.
    // Otherwise, set the index as 1. The id is only appended to the
    // hash if it's greater than 1.
    if(toc.hasOwnProperty(id)) {
      toc[id]++;
      id = [id, toc[id]].join('-');
    } else {
      toc[id] = 1;
    }

    data.id = id;
    data.name = raw;

    heading.id = data.id;

    html = template(data);
    $(html).appendTo($tocWrapper);
  });
}

function showLiveDocBanner () {
  var host = window.location.hostname;

  !host.match(/documenter.*\.getpostman\.com/) && host.match(/\.getpostman\.com$/) &&
    $('#live-documentation-banner').removeClass('is-hidden');
}

/**
 * Depending on the button, binds a handler to the publish button. If the button
 * has a `href` defined, a handler to build the publish URL is bound. Otherwise.
 * a tooltip is bound.
 */
function bindPublishButtonHandler () {
  var $cta = $('#initiate_publish_button');

  ($cta && $cta[0] && $cta[0].hasAttribute('href') && $cta.on('click', modifyPublishURL)) ||
    $cta.on('click', togglePublishTooltip);
}

function togglePublishTooltip () {
  $('.tt-block-publish').toggleClass('in');
}

// Adding meta to send to server when publish is initiated.
function modifyPublishURL () {
  var path = window.location.pathname,
    // composite id
    cId = path.split('/').slice(-1)[0].split('-'),
    owner = cId[0],
    collectionId = cId.slice(1).join('-'),
    params = $.param({
      collection_id : collectionId,
      owner: owner,
      collection_name: initialJson.collection.info.name
    }),
    // Stupid hack , remove when you change the Publish button to do a form POST
    href = ($(this).attr('href').indexOf('meta') > 0) ? $(this).attr('href') :
      ($(this).attr('href') + '?meta=' + window.btoa(params));

  $(this).attr('href', href);
}
