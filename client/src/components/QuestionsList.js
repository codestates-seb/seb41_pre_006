import styled from "styled-components";
// import { json } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

// import Pagination from "react-js-pagination";
// import { useDispatch, useSelector } from "react-redux";

import HomeHeaderRow from "../components/HomeHeaderRow";
import QuestionRow from "./QuestionRow";

const ListWrapper = styled.div`
  width: 100%;
`;

const QuestionsList = () => {
  // 질문목록리스트 상태 데모입니다.
  const [question, setQuestion] = useState([]);

  const LoadQuestion = () => {
    useEffect(() => {
      axios
        .get("/questions")
        .then((res) => {
          setQuestion(res.data);
          // console.log(question);
          console.log(res.data);
          // console.log(res.data[0]);
        })
        .catch((error) => console.log("error : ", error));
    }, []);
  };
  LoadQuestion();
  // setQuestion(LoadQuestion);

  return (
    <ListWrapper>
      <HomeHeaderRow />
      {question.map((question) => (
        <QuestionRow key={question.questionId} question={question} />
      ))}
    </ListWrapper>
  );
};

export default QuestionsList;
