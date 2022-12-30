import styled from "styled-components";
import axios from "axios";
import Nav from "../components/Nav";
import Sidebar from "../components/Sidebar";
import AskButton from "../components/AskButton";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
const Container = styled.section`
  display: flex;
  /* padding-top: 54px; */
  width: 100%;
  background: none;
  margin: 0 auto;
`;

const Wrapper = styled.div`
  width: 100%;
  margin: 24px;
`;

const InnerH = styled.div`
  display: flex;
  flex-direction: column;
  border-bottom: 1px solid #e3e6e8;
  > div {
    display: flex;
    justify-content: space-between;
    padding-bottom: 10px;
    > span {
      padding-top: 10px;
    }
  }
`;

const InnerW = styled.div`
  display: flex;
  margin-top: 24px;
  height: auto;
`;

const StyledHeader = styled.h1`
  margin-top: 20px;
  margin-bottom: 10px;
  font-size: 1.5rem;
  font-weight: 500;
`;

const Inner = styled.div`
  width: 100%;
  margin: 0 16px;
  height: auto;

  dispaly: flex;
  flex-direction: row;
`;
const Div = styled.div`
margin: 30px;
padding: 30px;
width:100%
height: auto;
border: 1px solid lightgray;
border-radius: 5px;
background-color: white;
 

 .content{margin: 30px auto 10px 0;
font-size: 1.3em;}
 .answer{
  padding: 30px;
  border-bottom: dotted 5px lightgray;
  margin: 30px auto 50px 0;
  > div { padding-top:20px; }
 }
`;

// demo components 레이아웃용 데모 스타일 입니다.
const Votes = styled.div`
  width: 32px;
  height: 100px;
  color: #6a737c;
  text-align: center;
  a {
    display: block;
    font-size: 32px;
  }
  p {
    margin: 8px 0;
    font-size: 24px;
  }
`;

const QuestionDetailPage = () => {
  // id에 해당하는 데이터 res 받아오기
  // 해당 데이터 div 안에 넣기
  // ↓ 질문 데이터
  const [data, setData] = useState({});
  const [date, setDate] = useState("");
  // ↓ 답변 데이터
  const [answer, setAnswer] = useState([]);
  const params = useParams();
  useEffect(() => {
    axios.get(`/questions/${params.num}`).then((res) => {
      setData(res.data);
      console.log(res.data);
      setAnswer(res.data.answerList);
      setDate(res.data.createdAt);
    });
  }, []);

  // 답변 리스트 element 생성할 함수

  return (
    <Container>
      <Nav />
      <Wrapper>
        <InnerH>
          <StyledHeader>{data.title}</StyledHeader>
          <div>
            <span>
              Asked {date.substring(0, 10)} Viewed {data.viewCount} times
            </span>
            <AskButton />
          </div>
        </InnerH>

        <InnerW>
          <Votes>
            <a href="/">▲</a>
            <p>1</p>
            <a href="/">▼</a>
          </Votes>
          <Inner>
            <Div className="질문 본문">
              <div>작성자 {data.userName}</div>
              <div className="content">{data.content}</div>
            </Div>
            <Div className="답변 컨테이너">
              <span className="content">{answer.length} Answer</span>
              {answer.map((el) => (
                <div className="answer" key={el.answerId}>
                  <span>작성자 {el.userName}</span>
                  <div className="content">{el.content}</div>
                </div>
              ))}
            </Div>
          </Inner>
          <Sidebar />
        </InnerW>
      </Wrapper>
    </Container>
  );
};

export default QuestionDetailPage;
