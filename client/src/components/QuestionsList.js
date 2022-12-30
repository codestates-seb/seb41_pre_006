import styled from "styled-components";
// import { json } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

// import Paging from "../components/paging";
// import { useDispatch, useSelector } from "react-redux";

import HomeHeaderRow from "../components/HomeHeaderRow";
import QuestionRow from "./QuestionRow";

const ListWrapper = styled.div`
  width: 100%;
`;

const PageList = styled.div`
  display: flex;
  justify-content: flex-end;
`;
const Button = styled.button`
  width: 50px;
  height: 50px;
  margin: 5px;
  border: solid 1px lightgray;
  border-radius: 4px;
  background-color: ${(props) => props.color};
`;

const QuestionsList = () => {
  // 질문목록리스트 상태 데모입니다.
  const [question, setQuestion] = useState([]);

  // 페이지 갯수
  const [pageNum, setPageNum] = useState(3);
  axios.get("/questions").then((res) => {
    setPageNum(parseInt(res.data.length / 8) + 1);
  });

  // 현재 페이지
  const [page, setPage] = useState(1);
  // api 포인트
  const url = `/questions?page=${page}&size=8`;

  // const LoadQuestion = () => {
  useEffect(() => {
    axios
      .get(url)
      .then((res) => {
        setQuestion(res.data);
      })
      .catch((error) => console.log(error));
  }, [page]);
  // };
  // LoadQuestion();
  // 렌더 이슈를 잡지 못했습니다. 임시 PR해둘게요

  // 페이지 버튼 생성 함수
  const pageRender = (r, f) => {
    let result = [];
    for (let i = 1; i <= r; i++) {
      result.push(
        <Button
          color={i === page ? "orange" : "white"}
          key={i}
          onClick={() => f(i)}
        >
          {i}
        </Button>
      );
    }
    return result;
  };

  return (
    <ListWrapper>
      <HomeHeaderRow />
      {question.map((question) => (
        <QuestionRow key={question.questionId} question={question} />
      ))}
      <PageList>{pageRender(pageNum, setPage)}</PageList>
    </ListWrapper>
  );
};

export default QuestionsList;
