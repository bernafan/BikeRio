<!DOCTYPE html>
<html>
  <head>
    <title>Lat/Lng Object Literal</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 500px;
        width: 500px;
        float: right;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY"></script>
    <script>
      // In this example, we center the map, and add a marker, using a LatLng object
      // literal instead of a google.maps.LatLng object. LatLng object literals are
      // a convenient way to add a LatLng coordinate and, in most cases, can be used
      // in place of a google.maps.LatLng object.

      var map;
      function initialize() {
        var mapOptions = {
          zoom: 8,
          center: {lat: -34.397, lng: 150.644}
        };
        map = new google.maps.Map(document.getElementById('map'),
            mapOptions);

        var marker = new google.maps.Marker({
          // The below line is equivalent to writing:
          // position: new google.maps.LatLng(-34.397, 150.644)
          position: {lat: -34.397, lng: 150.644},
          map: map
        });

        // You can use a LatLng literal in place of a google.maps.LatLng object when
        // creating the Marker object. Once the Marker object is instantiated, its
        // position will be available as a google.maps.LatLng object. In this case,
        // we retrieve the marker's position using the
        // google.maps.LatLng.getPosition() method.
        var infowindow = new google.maps.InfoWindow({
          content: '<p>Marker Location:' + marker.getPosition() + '</p>'
        });

        google.maps.event.addListener(marker, 'click', function() {
          infowindow.open(map, marker);
        });
      }

      google.maps.event.addDomListener(window, 'load', initialize);
      
      function UserAction() {
    	    var xhttp = new XMLHttpRequest();
    	    xhttp.onreadystatechange = function() {
    	         if (this.readyState == 4 && this.status == 200) {
    	             alert(this.responseText);
    	         }
    	    };
    	    xhttp.open("POST", "Your Rest URL Here", true);
    	    xhttp.setRequestHeader("Content-type", "application/json");
    	    xhttp.send("Your JSON Data Here");
    	}
      
    </script>
  </head>
  <body>
  	<form action="../BikeRio/api/formulario" method="POST">
    		<label for="end">Endereço:</label>
    		<input name="end" />
  
    <button type="submit" onclick="UserAction()">Search</button>
    </form>
  
  
    <div id="map"></div>
  </body>
</html>
