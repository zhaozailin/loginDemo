// 配置模块路径
requirejs.config({

    // 根目录
    baseUrl : "resources/scripts",

    // 指定模块id
    paths : {
        domReady : "libs/require/domReady",
        simple : "libs/photoSwipe/scripts/simple-inheritance.min",
        photoSwipe : "libs/photoSwipe/scripts/code-photoswipe-1.0.11.min"
    }
});

// 启动主方法
requirejs([ "domReady", "simple", "photoSwipe"], function(domReady, simple, photoSwipe) {
    domReady(function() {
        
        // Set up PhotoSwipe
        Code.PhotoSwipe.Current.setOptions({
            getImageSource: function(obj){
                return obj.url;
            },
            getImageCaption: function(obj){
                return obj.caption;
            }
        });
        
        Code.PhotoSwipe.Current.setImages([
            { url: 'resources/images/full/001.jpg', caption: 'Image 001'},
            { url: 'resources/images/full/002.jpg', caption: 'Image 002'},
            { url: 'resources/images/full/003.jpg', caption: 'Image 003'},
            { url: 'resources/images/full/004.jpg', caption: 'Image 004'},
            { url: 'resources/images/full/005.jpg', caption: 'Image 005'},
            { url: 'resources/images/full/006.jpg', caption: 'Image 006'},
            { url: 'resources/images/full/007.jpg', caption: 'Image 007'},
            { url: 'resources/images/full/008.jpg', caption: 'Image 008'},
            { url: 'resources/images/full/009.jpg', caption: 'Image 009'},
            { url: 'resources/images/full/010.jpg', caption: 'Image 010'},
            { url: 'resources/images/full/011.jpg', caption: 'Image 011'},
            { url: 'resources/images/full/012.jpg', caption: 'Image 012'},
            { url: 'resources/images/full/013.jpg', caption: 'Image 013'},
            { url: 'resources/images/full/014.jpg', caption: 'Image 014'},
            { url: 'resources/images/full/015.jpg', caption: 'Image 015'},
            { url: 'resources/images/full/016.jpg', caption: 'Image 016'},
            { url: 'resources/images/full/017.jpg', caption: 'Image 017'},
            { url: 'resources/images/full/018.jpg', caption: 'Image 018'}
        ]);
    
        Code.PhotoSwipe.Current.show(0);
    });
});
