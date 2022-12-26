export const refreshToken = async () => {
  const accessToken = localStorage.getItem('accessToken');
  const refreshToken = localStorage.getItem('refreshToken');

  const options = {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      'ngrok-skip-browser-warning': 'skip',
      Authorization: accessToken,
      Refresh: refreshToken,
    },
  };
  const res = await fetch('/token', options);
  console.log(res);
  console.log('토큰 재발급 완료');
  localStorage.setItem('accessToken', res.headers.get('authorization'));
  localStorage.setItem('refreshToken', res.headers.get('refresh'));
};
