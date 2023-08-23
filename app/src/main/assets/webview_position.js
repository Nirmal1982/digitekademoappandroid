function display_webview_position(webViewPosition, headerHeight, nestedScrollViewHeight, initialPosition) {
    console.log("-------------------------------------------")
    console.log("Initial vertical position of the webview: " + initialPosition);
    console.log("Height of nested scroll view: " + nestedScrollViewHeight); // En effet, c'est l'hauteur de la NestedScrollView qui contient la WebView. L'hauteur de la WebView est sa hauteur complète du début de l'article en haut jusqu'à la fin tout en bas.
    console.log("Height of header: " + headerHeight); // Header height is the same as footer height
    console.log("Current absolute vertical position of webview: " + webViewPosition);
}
