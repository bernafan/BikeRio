<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Google Maps v3 API Example</title>
        <style>
            html, body, #map {
                height: 70%;
                width: 80%;
                margin: 0;
                padding: 0;
            }
            div#footer {
                position: fixed;
                left: 0;
                right: 0;
                bottom: 0;
                width: 100%;
                height: 18px;
                margin: 0;
                padding: 6px;
                z-index: 2;
                background: WHITE;
            }
        </style> 
    </head>
    <body>
        <div id="map" style="float: left;"></div>
        
        <div id="footer">&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors</div>
        
        <!-- bring in the google maps library -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=true"></script>
        
        <script type="text/javascript">
            //Google maps API initialisation
            var element = document.getElementById("map");
 
            var map = new google.maps.Map(element, {
                center: new google.maps.LatLng(57, 21),
                zoom: 3,
                mapTypeId: "OSM",
                mapTypeControl: false,
                streetViewControl: false
            });
 
            //Define OSM map type pointing at the OpenStreetMap tile server
            map.mapTypes.set("OSM", new google.maps.ImageMapType({
                getTileUrl: function(coord, zoom) {
                    // "Wrap" x (logitude) at 180th meridian properly
                    // NB: Don't touch coord.x because coord param is by reference, and changing its x property breakes something in Google's lib 
                    var tilesPerGlobe = 1 << zoom;
                    var x = coord.x % tilesPerGlobe;
                    if (x < 0) {
                        x = tilesPerGlobe+x;
                    }
                    // Wrap y (latitude) in a like manner if you want to enable vertical infinite scroll

                    return "https://tile.openstreetmap.org/" + zoom + "/" + x + "/" + coord.y + ".png";
                },
                tileSize: new google.maps.Size(256, 256),
                name: "OpenStreetMap",
                maxZoom: 18
            }));
        </script>
    </body>
</html>