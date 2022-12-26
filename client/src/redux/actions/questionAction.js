export const GET_QUESTION = 'GET_QUESTION';
export const ADD_ANSWER = 'ADD_ANSWER';
export const EDIT_ANSWER = 'EDIT_ANSWER';
export const DELETE_ANSWER = 'DELETE_ANSWER';

export const VOTE_UP_QUESTION = 'VOTE_UP_QUESTION';
export const VOTE_DOWN_QUESTION = 'VOTE_DOWN_QUESTION';
export const VOTE_UP_ANSWER = 'VOTE_UP_ANSWER';
export const VOTE_DOWN_ANSWER = 'VOTE_DOWN_ANSWER';

export const getQuestion = (res) => {
  return {
    type: GET_QUESTION,
    payload: res, // 질문 데이터
  };
};

export const addAnswer = (res) => {
  return {
    type: ADD_ANSWER,
    payload: res, // 생성한 답변 데이터
  };
};

export const editAnswer = (res) => {
  return {
    type: EDIT_ANSWER,
    payload: res, // 수정한 답변 데이터
  };
};

export const deleteAnswer = (res) => {
  return {
    type: DELETE_ANSWER,
    payload: res, // 삭제한 답변 id
  };
};

// 🟢🟢🟢🟢🟢 투표

export const voteUpQuestion = (res) => {
  return {
    type: VOTE_UP_QUESTION,
    payload: res, // 질문 투표 수
  };
};

export const voteDownQuestion = (res) => {
  return {
    type: VOTE_DOWN_QUESTION,
    payload: res, // 질문 투표 수
  };
};

export const voteUpAnswer = (res) => {
  return {
    type: VOTE_UP_ANSWER,
    payload: res, // 답변 데이터 (투표 수 적용)
  };
};

export const voteDownAnswer = (res) => {
  return {
    type: VOTE_DOWN_ANSWER,
    payload: res, // 답변 데이터 (투표 수 적용)
  };
};
