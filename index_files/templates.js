this["Handlebars"] = this["Handlebars"] || {};
this["Handlebars"]["templates"] = this["Handlebars"]["templates"] || {};

Handlebars.registerPartial("_folder-doc-info", Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function";

  return "<div class=\"api-information\">\n  <div class=\"folder-name\"><p>"
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"name","hash":{},"data":data}) : helper)))
    + "</p></div>\n  <div class=\"folder-description\">"
    + ((stack1 = ((helper = (helper = helpers.description || (depth0 != null ? depth0.description : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"description","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</div>\n</div>\n";
},"useData":true}));

Handlebars.registerPartial("_folder-doc", Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "  <div class=\"col-md-6 col-xs-12 section\">\n    "
    + ((stack1 = container.invokePartial(partials["_folder-doc-info"],depth0,{"name":"_folder-doc-info","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "  </div>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.items : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.program(1, data, 0),"data":data})) != null ? stack1 : "");
},"usePartial":true,"useData":true}));

Handlebars.registerPartial("_folder-sidebar", Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<div class=\"col-md-6 col-xs-12 examples folder-examples\"></div>\n";
},"useData":true}));

Handlebars.registerPartial("_folder", Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper;

  return "<div class=\"row row-no-padding row-eq-height\" id=\""
    + container.escapeExpression(((helper = (helper = helpers.route || (depth0 != null ? depth0.route : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"route","hash":{},"data":data}) : helper)))
    + "\">\n  "
    + ((stack1 = container.invokePartial(partials["_folder-doc"],depth0,{"name":"_folder-doc","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "  "
    + ((stack1 = container.invokePartial(partials["_folder-sidebar"],depth0,{"name":"_folder-sidebar","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "</div>\n";
},"usePartial":true,"useData":true}));

Handlebars.registerPartial("_introduction-doc", Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function";

  return "<div class=\"col-md-6 col-xs-12 section\">\n  <div class=\"api-information\">\n    <div class=\"collection-name\">\n      <p>"
    + container.escapeExpression(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"name","hash":{},"data":data}) : helper)))
    + "</p>\n    </div>\n    <div class=\"collection-description\">"
    + ((stack1 = ((helper = (helper = helpers.description || (depth0 != null ? depth0.description : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"description","hash":{},"data":data}) : helper))) != null ? stack1 : "")
    + "</div>\n  </div>\n</div>\n";
},"useData":true}));

Handlebars.registerPartial("_introduction-sidebar", Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "    <div class=\"language hidden-xs hidden-sm\">\n      <div class=\"language-heading\">Language</div>\n      <div class=\"btn-group languages\">\n        <button type=\"button\" class=\"btn btn-default dropdown-toggle language-button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n          <div class=\"active-lang ellipsis\">"
    + container.escapeExpression(container.lambda(((stack1 = ((stack1 = (depth0 != null ? depth0.languages : depth0)) != null ? stack1["0"] : stack1)) != null ? stack1.name : stack1), depth0))
    + "</div>\n          <span class=\"pm-doc-sprite pm-doc-sprite-dropdown-caret\"></span>\n        </button>\n        <ul class=\"dropdown-menu dropdown-menu-right language_dropdown\">\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.languages : depth0),{"name":"each","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </ul>\n      </div>\n    </div>\n";
},"2":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "          <li class=\"dropdown-menu-item\" data-snippetname="
    + alias4(((helper = (helper = helpers.target || (depth0 != null ? depth0.target : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"target","hash":{},"data":data}) : helper)))
    + ":"
    + alias4(((helper = (helper = helpers.client || (depth0 != null ? depth0.client : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"client","hash":{},"data":data}) : helper)))
    + ">"
    + alias4(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"name","hash":{},"data":data}) : helper)))
    + "</li>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div class=\"col-md-6 col-xs-12 examples\">\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.languages : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</div>\n";
},"useData":true}));

Handlebars.registerPartial("_introduction", Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div class=\"row row-no-padding row-eq-height\" id=\"intro\">\n  "
    + ((stack1 = container.invokePartial(partials["_introduction-doc"],depth0,{"name":"_introduction-doc","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "  "
    + ((stack1 = container.invokePartial(partials["_introduction-sidebar"],depth0,{"name":"_introduction-sidebar","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "</div>\n";
},"usePartial":true,"useData":true}));

Handlebars.registerPartial("_item-doc", Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    return "          <span class=\"lock-icon\"></span>\n";
},"3":function(container,depth0,helpers,partials,data) {
    return "";
},"5":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "      <div class=\"headers\">\n        <div class=\"headers-heading\">HEADERS</div>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.headers : stack1),{"name":"each","hash":{},"fn":container.program(6, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "      </div>\n";
},"6":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "          <hr>\n          <div class=\"param row\">\n            <div class=\"name col-md-3\">"
    + alias4(((helper = (helper = helpers.key || (depth0 != null ? depth0.key : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"key","hash":{},"data":data}) : helper)))
    + "</div>\n            <div class=\"value col-md-9\">"
    + alias4(((helper = (helper = helpers.value || (depth0 != null ? depth0.value : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"value","hash":{},"data":data}) : helper)))
    + "</div>\n          </div>\n";
},"8":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "      <div class=\"request-body\">\n        <div class=\"body-heading\">BODY</div>\n"
    + ((stack1 = (helpers.ifeq || (depth0 && depth0.ifeq) || helpers.helperMissing).call(depth0 != null ? depth0 : {},((stack1 = ((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.data : stack1)) != null ? stack1.mode : stack1),"raw",{"name":"ifeq","hash":{},"fn":container.program(9, data, 0),"inverse":container.program(14, data, 0),"data":data})) != null ? stack1 : "")
    + "      </div>\n";
},"9":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "          <hr>\n          <div class = \"raw-body code-snippet\">\n"
    + ((stack1 = (helpers.ifeq || (depth0 && depth0.ifeq) || helpers.helperMissing).call(depth0 != null ? depth0 : {},((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.headers : stack1)) != null ? stack1["0"] : stack1)) != null ? stack1.value : stack1),"text/xml",{"name":"ifeq","hash":{},"fn":container.program(10, data, 0),"inverse":container.program(12, data, 0),"data":data})) != null ? stack1 : "")
    + "          </div>\n\n";
},"10":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "              <pre class=\"body-block\"><code class=\"body-block language-xml\">"
    + container.escapeExpression(container.lambda(((stack1 = ((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.data : stack1)) != null ? stack1.content : stack1), depth0))
    + "</code></pre>\n";
},"12":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "            <pre class=\"body-block\"><code class=\"body-block language-javascript\">"
    + container.escapeExpression(container.lambda(((stack1 = ((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.data : stack1)) != null ? stack1.content : stack1), depth0))
    + "</code></pre>\n";
},"14":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},((stack1 = ((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.data : stack1)) != null ? stack1.content : stack1),{"name":"each","hash":{},"fn":container.program(15, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"15":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "            <hr>\n            <div class=\"param row\">\n              <div class=\"name col-md-3\">"
    + alias4(((helper = (helper = helpers.key || (depth0 != null ? depth0.key : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"key","hash":{},"data":data}) : helper)))
    + "</div>\n              <div class=\"value col-md-9\">"
    + alias4(((helper = (helper = helpers.value || (depth0 != null ? depth0.value : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"value","hash":{},"data":data}) : helper)))
    + "</div>\n            </div>\n";
},"17":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "      <div class=\"attributes\">\n         <div class=\"attr-heading\">URL Params</div>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.attributes : depth0),{"name":"each","hash":{},"fn":container.program(18, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "      </div>\n";
},"18":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "          <hr>\n          <div class = \"attr-name\"><b>"
    + alias4(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"name","hash":{},"data":data}) : helper)))
    + "</b> </div>\n          <div class=\"attr-description\">"
    + alias4(((helper = (helper = helpers.description || (depth0 != null ? depth0.description : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"description","hash":{},"data":data}) : helper)))
    + ".</div>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=container.lambda, alias2=container.escapeExpression, alias3=depth0 != null ? depth0 : {}, alias4=helpers.helperMissing;

  return "<div class=\"col-md-6 col-xs-12 section\">\n  <div class=\"api-information\">\n    <div class=\"heading\">\n      <div class=\"name\">\n        <span class=\""
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.method : stack1), depth0))
    + " method\">"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.method : stack1), depth0))
    + "</span>\n        "
    + alias2(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : alias4),(typeof helper === "function" ? helper.call(alias3,{"name":"name","hash":{},"data":data}) : helper)))
    + "\n"
    + ((stack1 = (helpers.ifnoteq || (depth0 && depth0.ifnoteq) || alias4).call(alias3,((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1._postman_currentHelper : stack1),"normal",{"name":"ifnoteq","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "      </div>\n    </div>\n    <div class=\"url\">"
    + alias2(alias1(((stack1 = ((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.url : stack1)) != null ? stack1.href : stack1), depth0))
    + "</div>\n    <div class=\"description\">"
    + ((stack1 = alias1(((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.description : stack1), depth0)) != null ? stack1 : "")
    + "</div>\n\n"
    + ((stack1 = helpers["if"].call(alias3,(depth0 != null ? depth0.authorization : depth0),{"name":"if","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias3,((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.headers : stack1),{"name":"if","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(alias3,((stack1 = ((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.data : stack1)) != null ? stack1.content : stack1),{"name":"if","hash":{},"fn":container.program(8, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\n"
    + ((stack1 = helpers["if"].call(alias3,((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1.params : stack1),{"name":"if","hash":{},"fn":container.program(17, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "  </div>\n  <br><br>\n</div>\n\n\n";
},"useData":true}));

Handlebars.registerPartial("_item-sidebar", Handlebars.template({"1":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, alias1=depth0 != null ? depth0 : {};

  return "\n    <div class=\"sample-request\">\n      <div class=\"heading\"><span>Sample Request</span></div>\n\n      <div class=\"responses-index\">\n"
    + ((stack1 = (helpers.ifeq || (depth0 && depth0.ifeq) || helpers.helperMissing).call(alias1,((stack1 = (depth0 != null ? depth0.sample : depth0)) != null ? stack1.length : stack1),1,{"name":"ifeq","hash":{},"fn":container.program(2, data, 0, blockParams, depths),"inverse":container.program(4, data, 0, blockParams, depths),"data":data})) != null ? stack1 : "")
    + "      </div>\n    </div>\n\n    <div class=\"request code-snippet\">\n"
    + ((stack1 = helpers.each.call(alias1,(depth0 != null ? depth0.sample : depth0),{"name":"each","hash":{},"fn":container.program(7, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    </div>\n\n"
    + ((stack1 = helpers["if"].call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.sample : depth0)) != null ? stack1["0"] : stack1)) != null ? stack1.response : stack1)) != null ? stack1.text : stack1),{"name":"if","hash":{},"fn":container.program(10, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"2":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "          <div class=\"response-name\"><span>"
    + container.escapeExpression(container.lambda(((stack1 = ((stack1 = (depth0 != null ? depth0.sample : depth0)) != null ? stack1["0"] : stack1)) != null ? stack1.name : stack1), depth0))
    + "</span></div>\n";
},"4":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, alias1=container.lambda, alias2=container.escapeExpression;

  return "          <div class=\"dropdown response-name\">\n            <button class=\"btn dropdown-toggle responses-dropdown truncate\" type=\"button\" id=\""
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1._postman_compat_id : stack1), depth0))
    + "_dropdown\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"true\">"
    + alias2(alias1(((stack1 = ((stack1 = (depth0 != null ? depth0.sample : depth0)) != null ? stack1["0"] : stack1)) != null ? stack1.name : stack1), depth0))
    + "<span class=\"caret\"></span></button>\n            <ul class=\"dropdown-menu\" aria-labelledby=\""
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1._postman_compat_id : stack1), depth0))
    + "_dropdown\">\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.sample : depth0),{"name":"each","hash":{},"fn":container.program(5, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </ul>\n          </div>\n";
},"5":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper, alias1=container.lambda, alias2=container.escapeExpression, alias3=depth0 != null ? depth0 : {}, alias4=helpers.helperMissing, alias5="function";

  return "                <li class=\"truncate\" data-request-info=\""
    + alias2(alias1(((stack1 = (depths[1] != null ? depths[1].request : depths[1])) != null ? stack1._postman_compat_id : stack1), depth0))
    + "_"
    + alias2(((helper = (helper = helpers.index || (data && data.index)) != null ? helper : alias4),(typeof helper === alias5 ? helper.call(alias3,{"name":"index","hash":{},"data":data}) : helper)))
    + "\" data-request-name=\""
    + alias2(alias1(((stack1 = (depths[1] != null ? depths[1].request : depths[1])) != null ? stack1._postman_compat_id : stack1), depth0))
    + "\">"
    + alias2(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : alias4),(typeof helper === alias5 ? helper.call(alias3,{"name":"name","hash":{},"data":data}) : helper)))
    + "</li>\n";
},"7":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.snippet : depth0),{"name":"each","hash":{},"fn":container.program(8, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"8":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3=container.escapeExpression, alias4=container.lambda;

  return "          <div class=\"formatted-requests\" data-lang=\""
    + alias3(((helper = (helper = helpers.key || (data && data.key)) != null ? helper : alias2),(typeof helper === "function" ? helper.call(alias1,{"name":"key","hash":{},"data":data}) : helper)))
    + "\" data-id=\""
    + alias3(alias4(((stack1 = (depths[1] != null ? depths[1].request : depths[1])) != null ? stack1._postman_compat_id : stack1), depth0))
    + "_"
    + alias3(alias4((container.data(data, 1) && container.data(data, 1).index), depth0))
    + "\">\n            <pre><button class=\"btn btn-sm pull-right copy-request copy-request-modal\" data-clipboard-target=\"#"
    + ((stack1 = (helpers.generateRequestID || (depth0 && depth0.generateRequestID) || alias2).call(alias1,{"name":"generateRequestID","hash":{"lang":(data && data.key),"requestId":(container.data(data, 1) && container.data(data, 1).index),"request":((stack1 = (depths[1] != null ? depths[1].request : depths[1])) != null ? stack1._postman_compat_id : stack1)},"data":data})) != null ? stack1 : "")
    + "\" data-before-copy=\"Copy to Clipboard\" data-after-copy=\"Copied\"></button><code class=\"language-javascript\" id=\""
    + ((stack1 = (helpers.generateRequestID || (depth0 && depth0.generateRequestID) || alias2).call(alias1,{"name":"generateRequestID","hash":{"lang":(data && data.key),"requestId":(container.data(data, 1) && container.data(data, 1).index),"request":((stack1 = (depths[1] != null ? depths[1].request : depths[1])) != null ? stack1._postman_compat_id : stack1)},"data":data})) != null ? stack1 : "")
    + "\">"
    + alias3(alias4(depth0, depth0))
    + "</code></pre>\n            <!-- Button over the expand overlay -->\n            <button class=\"btn btn-sm pull-right copy-request\" data-clipboard-target=\"#"
    + ((stack1 = (helpers.generateRequestID || (depth0 && depth0.generateRequestID) || alias2).call(alias1,{"name":"generateRequestID","hash":{"lang":(data && data.key),"requestId":(container.data(data, 1) && container.data(data, 1).index),"request":((stack1 = (depths[1] != null ? depths[1].request : depths[1])) != null ? stack1._postman_compat_id : stack1)},"data":data})) != null ? stack1 : "")
    + "\" data-before-copy=\"Copy to Clipboard\" data-after-copy=\"Copied\"></button>\n          </div>\n";
},"10":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return "      <div class=\"response-heading\"><span>Sample Response</span></div>\n\n      <div class=\"responses code-snippet\">\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.sample : depth0),{"name":"each","hash":{},"fn":container.program(11, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "      </div>\n";
},"11":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper, alias1=container.lambda, alias2=container.escapeExpression;

  return "          <div class=\"formatted-responses\" data-id=\""
    + alias2(alias1(((stack1 = (depths[1] != null ? depths[1].request : depths[1])) != null ? stack1._postman_compat_id : stack1), depth0))
    + "_"
    + alias2(((helper = (helper = helpers.index || (data && data.index)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"index","hash":{},"data":data}) : helper)))
    + "\">"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.response : depth0)) != null ? stack1.text : stack1), depth0))
    + "</div>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1;

  return "<div class=\"col-md-6 col-xs-12 examples\">"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.sample : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</div>\n";
},"useData":true,"useDepths":true}));

Handlebars.registerPartial("_item", Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div class=\"row row-no-padding row-eq-height\" id=\""
    + container.escapeExpression(container.lambda(((stack1 = (depth0 != null ? depth0.request : depth0)) != null ? stack1._postman_compat_id : stack1), depth0))
    + "\">\n  "
    + ((stack1 = container.invokePartial(partials["_item-doc"],depth0,{"name":"_item-doc","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "  "
    + ((stack1 = container.invokePartial(partials["_item-sidebar"],depth0,{"name":"_item-sidebar","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "</div>\n\n";
},"usePartial":true,"useData":true}));

this["Handlebars"]["templates"]["doc-sidebar"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "  "
    + ((stack1 = container.invokePartial(partials._introduction,depth0,{"name":"_introduction","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "");
},"3":function(container,depth0,helpers,partials,data) {
    var stack1, helper, options, buffer = "";

  stack1 = ((helper = (helper = helpers.ifIsFolder || (depth0 != null ? depth0.ifIsFolder : depth0)) != null ? helper : helpers.helperMissing),(options={"name":"ifIsFolder","hash":{},"fn":container.program(4, data, 0),"inverse":container.program(7, data, 0),"data":data}),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},options) : helper));
  if (!helpers.ifIsFolder) { stack1 = helpers.blockHelperMissing.call(depth0,stack1,options)}
  if (stack1 != null) { buffer += stack1; }
  return buffer;
},"4":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "    "
    + ((stack1 = container.invokePartial(partials._folder,depth0,{"name":"_folder","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.items : depth0),{"name":"each","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"5":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "      "
    + ((stack1 = container.invokePartial(partials._item,depth0,{"name":"_item","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "");
},"7":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "    "
    + ((stack1 = container.invokePartial(partials._item,depth0,{"name":"_item","data":data,"helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "");
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=depth0 != null ? depth0 : {};

  return ((stack1 = helpers["with"].call(alias1,(depth0 != null ? depth0.info : depth0),{"name":"with","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers.each.call(alias1,(depth0 != null ? depth0.items : depth0),{"name":"each","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "<div class=\"row row-no-padding row-eq-height dummy\">\n  <div class=\"col-md-6 col-xs-12 section\">\n    <div class=\"api-information\">\n    </div>\n  </div>\n  <div class=\"col-md-6 col-xs-12 examples\"></div>\n</div>\n";
},"usePartial":true,"useData":true});

this["Handlebars"]["templates"]["toc-item"] = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<li class=\"request heading\">\n  <a class=\"nav-link dropdown-item\" href='#"
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "'>\n    <div class=\"request-name\">"
    + alias4(((helper = (helper = helpers.name || (depth0 != null ? depth0.name : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"name","hash":{},"data":data}) : helper)))
    + "</div>\n  </a>\n</li>\n";
},"useData":true});