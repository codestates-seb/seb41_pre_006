export const GET_MYINFO = 'GET_MYINFO';
export const GET_LOGIN_STATUS = 'GET_LOGIN_STATUS';

export const getmyInfo = (res) => {
  return {
    type: GET_MYINFO,
    payload: res,
  };
};

export const getLoginStatus = (res) => {
  return {
    type: GET_LOGIN_STATUS,
    payload: res,
  };
};
