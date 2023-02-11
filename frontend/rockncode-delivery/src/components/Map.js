import React, { useCallback, useEffect, useState } from 'react'
import { DirectionsRenderer, GoogleMap, Marker, TrafficLayer, useJsApiLoader } from '@react-google-maps/api';

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
  const [position1, setPosition1] = useState({ lat: 37.7749, lng: -122.4194 });
  const [position2, setPosition2] = useState({ lat: 40.7128, lng: -74.0060 });
  const [route, setRoute] = useState(null);
  const onLoad = async () => {
    const directionsService = new window.google.maps.DirectionsService();
    const directionsDisplay = new window.google.maps.DirectionsRenderer();

    directionsService.route(
      {
        origin: origin,
        destination: destination,
        travelMode: window.google.maps.TravelMode.DRIVING
      },
      (result, status) => {
        if (status === window.google.maps.DirectionsStatus.OK) {
          setRoute(result);
        } else {
          console.error(`error fetching directions ${result}`);
        }
      }
    );
  };
console.log("directions", directions)
  const onUnmount = useCallback(function callback(map) {
    setMap(null)
  }, [])

  useEffect(() => {

    onLoad();
  }, []);

  return isLoaded ? (
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={10}
        onLoad={onLoad}
        onUnmount={onUnmount}
      >
        <TrafficLayer
                  onLoad={onLoad}
                />
                <Marker position={position1} onClick={() => setPosition1({ lat: 40.7128, lng: -74.0060 })} />
                <Marker position={position2} onClick={() => setPosition2({ lat: 37.7749, lng: -122.4194 })} />
                {route && <DirectionsRenderer options={{
                  directions: route
                }} />}
      </GoogleMap>
  ) : <></>
}

export default React.memo(Map);