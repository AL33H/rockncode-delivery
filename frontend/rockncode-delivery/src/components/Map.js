import React, { useCallback, useState } from 'react'
import { GoogleMap, useJsApiLoader } from '@react-google-maps/api';

const containerStyle = {
  width: '612px',
  height: '342px'
};

const center = {
  lat: -3.745,
  lng: -38.523
};

const origin = {
  lat: -10.4379422,
  lng: -59.9983108
};

const destination = {
  lat: -20.9068619,
  lng: -43.172946
};

function Map() {
  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    googleMapsApiKey: "AIzaSyAl3Ghn_SGqmM6ICQg9sYkjz_SOaBfHf5s"
  })


  const [map, setMap] = useState(null)
  const [directions, setDirections] = useState(null)
  const onLoad = useCallback(function callback(map) {
  
    const directionsService = new window.google.maps.DirectionsService();
    
  
    directionsService.route(
      {
        origin: origin,
        destination: destination,
        travelMode: window.google.maps.TravelMode.DRIVING
      },
      (result, status) => {
        if (status === window.google.maps.DirectionsStatus.OK) {
          setDirections(result);
        } else {
          console.error(`error fetching directions ${result}`);
        }
      }
    );
    setMap(map)
  }, [])
console.log("directions", directions)
  const onUnmount = useCallback(function callback(map) {
    setMap(null)
  }, [])

  return isLoaded ? (
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={10}
        onLoad={onLoad}
        onUnmount={onUnmount}
      >
        <></>
      </GoogleMap>
  ) : <></>
}

export default React.memo(Map);