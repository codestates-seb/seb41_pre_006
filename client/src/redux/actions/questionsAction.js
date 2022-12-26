export const GET_QUESTIONS = 'GET_QUESTIONS';
export const ADD_QUESTION = 'ADD_QUESTION';
export const EDIT_QUESTION = 'EDIT_QUESTION';
export const DELETE_QUESTION = 'DELETE_QUESTION';

export const getQuestions = (res) => {
  return {
    type: GET_QUESTIONS,
    payload: res, // 질문 리스트 데이터, 페이지 정보
  };
};

export const addQuestion = (res) => {
  return {
    type: ADD_QUESTION,
    payload: res, // 생성한 질문 데이터
  };
};

export const editQuestion = (res) => {
  return {
    type: EDIT_QUESTION,
    payload: res, // 수정한 질문 데이터
  };
};

export const deleteQuestion = (res) => {
  return {
    type: DELETE_QUESTION,
    payload: res, // 삭제한 질문 id
  };
};
