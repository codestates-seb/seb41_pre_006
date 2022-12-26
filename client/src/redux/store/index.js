import {
  legacy_createStore as createStore,
  compose,
  applyMiddleware,
} from 'redux';
import { rootReducer } from '../reducers';
import thunk from 'redux-thunk';

// export const store = createStore(rootReducer);
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
  ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({})
  : compose;

export const store = createStore(
  rootReducer,
  composeEnhancers(applyMiddleware(thunk))
);
