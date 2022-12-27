import {
  ADD_ANSWER,
  DELETE_ANSWER,
  EDIT_ANSWER,
  GET_QUESTION,
  VOTE_UP_QUESTION,
  VOTE_DOWN_QUESTION,
  VOTE_UP_ANSWER,
  VOTE_DOWN_ANSWER,
} from '../actions/questionAction';

const initialState = {
  articleId: 0,
  title: '',
  content: '',
  email: '',
  vote: 0,
  createAt: '',
  tags: [],
  comments: [],
};

export const questionReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_QUESTION:
      return { ...state, ...action.payload.data };
    case ADD_ANSWER:
      return { ...state, comments: [...state.comments, action.payload.data] };
    case EDIT_ANSWER:
      return {
        ...state,
        comments: [
          ...state.comments.map((answer) => {
            if (answer.commentId === action.payload.data.commentId)
              answer = action.payload.data;

            return answer;
          }),
        ],
      };
    case DELETE_ANSWER:
      return {
        ...state,
        comments: [
          ...state.comments.filter(
            (answer) => answer.commentId !== action.payload.commentId
          ),
        ],
      };
    case VOTE_UP_QUESTION:
      return {
        ...state,
        vote: action.payload.data,
      };
    case VOTE_DOWN_QUESTION:
      return {
        ...state,
        vote: action.payload.data,
      };
    case VOTE_UP_ANSWER:
      return {
        ...state,
        comments: [
          state.comments.map((answer) => {
            if (answer.commentId === action.payload.data.commentId)
              answer.vote = action.payload.data.vote;

            return answer;
          }),
        ],
      };
    case VOTE_DOWN_ANSWER:
      return {
        ...state,
        comments: [
          state.comments.map((answer) => {
            if (answer.commentId === action.payload.data.commentId)
              answer.vote = action.payload.data.vote;

            return answer;
          }),
        ],
      };
    default:
      return state;
  }
};
