const useFetch = (method, url, fetchData) => {
  const accessToken = localStorage.getItem("accessToken");

  // 기본 옵션
  const defaultOptions = {
    method: method,
    headers: {
      "Content-Type": "application/json",
      "ngrok-skip-browser-warning": "skip",
      Authorization: accessToken
    },
    body: JSON.stringify(fetchData)
  };

  return fetch(url, defaultOptions).then(async (res) => {
    if (!res.ok) {
      return res.status;
      // throw Error('에러발생');

      // 토큰이 있는 경우 (로그인)
    } else if (res.headers.get("authorization")) {
      localStorage.setItem("accessToken", res.headers.get("authorization"));
      localStorage.setItem("refreshToken", res.headers.get("refresh"));
      return res;
    }

    return res.json();
  });
};

export default useFetch;
