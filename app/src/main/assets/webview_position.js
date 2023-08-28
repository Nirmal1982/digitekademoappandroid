function display_webview_position(statusBarHeight, toolBarHeight, headerHeight, nestedScrollViewHeight, initialWebViewPosition, currentWebViewPosition, isPlayerLaunched) {
    if(!isPlayerLaunched){
        console.log("-------------------------------------------")
        console.log("Height of status bar: " + statusBarHeight); // Status bar height (uppermost bar with time and battery level)
        console.log("Height of tool bar: " + toolBarHeight); // Tool bar height (bar with app name)
        console.log("Height of header: " + headerHeight); // Header (orange) height is the same as footer (purple) height
        console.log("Height of nested scroll view: " + nestedScrollViewHeight); // In reality it is the height of the NestedScrollView which contains the WebView.
        console.log("Initial vertical position of the webview: " + initialWebViewPosition);
        console.log("Current absolute vertical position of webview: " + currentWebViewPosition);

        var nodes = document.querySelectorAll('iframe');
           for (var m = 0; m < nodes.length; m++) {
               if ((nodes[m].hasAttribute("src") && nodes[m].getAttribute("src").match(/(ultimedia|digiteka)\.(com|net)/)) || (nodes[m].hasAttribute("data-src") && nodes[m].getAttribute("data-src").match(/(ultimedia|digiteka)\.(com|net)/))) {
                  const rect = nodes[m].getBoundingClientRect();
                  var isVisible =  (rect.top + (nodes[m].offsetHeight / 2)) < (initialWebViewPosition - currentWebViewPosition) + nestedScrollViewHeight
                  if(isVisible){
                        nodes[m].contentWindow.postMessage('play', '*');
                        isPlayerLaunched = true;
                  }
               }
          }
    }
    return isPlayerLaunched;
}
