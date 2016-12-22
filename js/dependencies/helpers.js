Handlebars.registerHelper('ifeq', function (value, test, options) {
  if (value == test) { return options.fn(this); }
  else { return options.inverse(this); }
});
Handlebars.registerHelper('ifnoteq', function (value, test, options) {
  if (value != test) { return options.fn(this); }
  else { return options.inverse(this); }
});
Handlebars.registerHelper('ifIsFolder', function (options) {
  return this.hasOwnProperty('items') ? options.fn(this) : options.inverse(this);
});
Handlebars.registerHelper('generateRequestID', function (options) {
  var attrs = [];

  for (var prop in options.hash) {
    attrs.push(options.hash[prop]);
  }

  return new Handlebars.SafeString(
    attrs.join('_').replace(/\s+/g, '')
  );
});
