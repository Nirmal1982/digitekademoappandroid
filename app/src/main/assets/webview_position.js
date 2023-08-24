function display_webview_position(statusBarHeight, toolBarHeight, headerHeight, nestedScrollViewHeight, initialWebViewPosition, currentWebViewPosition) {
    console.log("-------------------------------------------")
    console.log("Height of status bar: " + statusBarHeight); // Status bar height (uppermost bar with time and battery level)
    console.log("Height of tool bar: " + toolBarHeight); // Tool bar height (bar with app name)
    console.log("Height of header: " + headerHeight); // Header (orange) height is the same as footer (purple) height
    console.log("Height of nested scroll view: " + nestedScrollViewHeight); // In reality it is the height of the NestedScrollView which contains the WebView.
    console.log("Initial vertical position of the webview: " + initialWebViewPosition);
    console.log("Current absolute vertical position of webview: " + currentWebViewPosition);
}
