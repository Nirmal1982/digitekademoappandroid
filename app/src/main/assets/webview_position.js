function display_webview_position(webViewPosition, headerHeight, webViewHeight) {
    console.log("Absolute position of webview: " + webViewPosition);
    console.log("Height of header: " + headerHeight); // Header height is the same as footer height
    console.log("Height of webview: " + webViewHeight); // En effet, c'est l'hauteur de la NestedScrollView qui contient la WebView. L'hauteur de la WebView est sa hauteur complète du début de l'article en haut jusqu'à la fin tout en bas.
}
