var messenger = {
  messageCache: [],
  queue: function() {
    this.messageCache.push(arguments);
  }
};
