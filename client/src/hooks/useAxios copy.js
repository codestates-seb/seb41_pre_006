import axios from 'axios';

// const DOMAIN = 'https://9f30-114-205-132-181.jp.ngrok.io';

const useAxios = (method, url, data) => {
  // return axios.post(url, {});

  return axios({
    method,
    url,
    data,
  })
    .then((res) => res.data)
    .catch((err) => console.log(err));
};

export default useAxios;
