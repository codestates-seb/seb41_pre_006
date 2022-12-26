import { combineReducers } from 'redux';
import { userReducer } from './userReducer';
import { questionReducer } from './questionReducer';
import { questionsReducer } from './questionsReducer';

export const rootReducer = combineReducers({
  questionReducer,
  questionsReducer,
  userReducer,
});
