import { GET_MYINFO, GET_LOGIN_STATUS } from '../actions/userAction';

const initialState = {
  isLogin: false,
};

export const userReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_MYINFO:
      return { ...state, ...action.payload };
    case GET_LOGIN_STATUS:
      return { ...state, ...action.payload };
    default:
      return state;
  }
};
