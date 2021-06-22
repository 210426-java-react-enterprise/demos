import axios from "axios";

const apiKey = "d2d06441aa2955582ee661a71419b55c";

export const currentWeather = async (city: string) => {
    let current = {
        lat: "",
        lon: "",
        city_id: "",
        description: "",
        icon: "",
        temp: "",
        pressure: "",
        humidity: "",
        wind: ""
  };

  const currentCall = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}`;

  await axios
    .get(currentCall)
    .then((res: any) => {
      current.lat = res.data.coord.lat;
      current.lon = res.data.coord.lon;
      current.city_id = res.data.id;
      current.description = res.data.weather[0].description;
      current.icon = res.data.weather[0].icon;
      current.temp = convertTemp(res.data.main.temp);
      current.pressure = res.data.main.pressure;
      current.humidity = res.data.main.humidity;
      current.wind = res.data.wind.speed;
    })
    .catch((err: any) => console.log(err));

  return current;
};

function convertTemp(temp: number) {
  let num = 1.8 * (temp - 273.15) + 32;
  return num.toFixed(0);
}
