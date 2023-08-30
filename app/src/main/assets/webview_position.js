    function display_webview_position(statusBarHeight, toolBarHeight, headerHeight, nestedScrollViewHeight, initialWebViewPosition, currentWebViewPosition, isPlayerLaunched, closeSticky) {
    if(typeof window.stickyClosed === 'undefined'){
        window.stickyClosed =false;
    }
    this.nodes = document.querySelectorAll('iframe');
    if(!isPlayerLaunched){
        console.log("-------------------------------------------")
        console.log("Height of status bar: " + statusBarHeight); // Status bar height (uppermost bar with time and battery level)
        console.log("Height of tool bar: " + toolBarHeight); // Tool bar height (bar with app name)
        console.log("Height of header: " + headerHeight); // Header (orange) height is the same as footer (purple) height
        console.log("Height of nested scroll view: " + nestedScrollViewHeight); // In reality it is the height of the NestedScrollView which contains the WebView.
        console.log("Initial vertical position of the webview: " + initialWebViewPosition);
        console.log("Current absolute vertical position of webview: " + currentWebViewPosition);
           for (let m = 0; m < this.nodes.length; m++) {
               if ((this.nodes[m].hasAttribute("src") && this.nodes[m].getAttribute("src").match(/(ultimedia|digiteka)\.(com|net)/)) || (this.nodes[m].hasAttribute("data-src") && this.nodes[m].getAttribute("data-src").match(/(ultimedia|digiteka)\.(com|net)/))) {
                  const rect = this.nodes[m].getBoundingClientRect();
                  var isVisible =  (rect.top + (this.nodes[m].offsetHeight / 2)) < (initialWebViewPosition - currentWebViewPosition) + nestedScrollViewHeight
                  if(isVisible){
                        ultimediaVisiblePlayer.toggleVisiblePlayer(m, true, this.nodes[m].offsetHeight, this.nodes[m].offsetWidth);
                        document.querySelector('.wrapper_vpp').classList.add('active');
                        this.nodes[m].contentWindow.postMessage('play', '*');
                        isPlayerLaunched = true;
                  }
               }
          }
    }else if(!window.stickyClosed){
        window.btn_close = window.btn_close || document.querySelector('.vpp_btn_close');
        if (!window.btn_close.hasListener){
            window.btn_close.addEventListener('click', function () {
               window.stickyClosed = true;
                    for (let m = 0; m < this.nodes.length; m++) {
                        if ((this.nodes[m].hasAttribute("src") && this.nodes[m].getAttribute("src").match(/(ultimedia|digiteka)\.(com|net)/)) || (this.nodes[m].hasAttribute("data-src") && this.nodes[m].getAttribute("data-src").match(/(ultimedia|digiteka)\.(com|net)/))) {
                            ultimediaVisiblePlayer.toggleVisiblePlayer(m, false);
                            this.nodes[m].style.setProperty('top', 0, 'important');
                        }
                    }
            });
            window.btn_close.hasListener = true;
        }
    for (let m = 0; m < this.nodes.length; m++) {
                   if ((this.nodes[m].hasAttribute("src") && this.nodes[m].getAttribute("src").match(/(ultimedia|digiteka)\.(com|net)/)) || (this.nodes[m].hasAttribute("data-src") && this.nodes[m].getAttribute("data-src").match(/(ultimedia|digiteka)\.(com|net)/))) {
                            this.nodes[m].style.setProperty('position', 'absolute', 'important');
                            setTimeout(function(){
                                this.nodes[m].style.setProperty('top', 0, 'important');
                                this.nodes[m].style.setProperty('transform', 'translateY(' + ((initialWebViewPosition - currentWebViewPosition) + nestedScrollViewHeight - this.nodes[m].offsetHeight) + 'px)', 'important');
                                document.querySelector('.wrapper_vpp').style.setProperty('top', 0, 'important');
                                document.querySelector('.wrapper_vpp').style.setProperty('transform', 'translateY(' + ((initialWebViewPosition - currentWebViewPosition) + nestedScrollViewHeight - this.nodes[m].offsetHeight) + 'px)', 'important');
                            }.bind(this),300);
                   }
    }
   }
  return {'isPlayerLaunched' : isPlayerLaunched, 'closeSticky' : window.stickyClosed};
}
