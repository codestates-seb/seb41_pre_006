import axios from "axios";
import { useEffect, useState } from "react";
import styled from "styled-components";
import Nav from "../components/Nav";
import SideBar from "../components/Sidebar";
import UserThumbnail from "../components/UserThumbnail";
const title = "Users";

const Container = styled.section`
  display: flex;
  flex-direction: row;
  background-color: beige;
  /* position: relative; */
  /* padding-top: 54px; */
  width: 100%;
  background: none;
  margin: 0 auto;
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  margin: 32px;
`;

const StyledHeader = styled.h1`
  margin-bottom: 20px;
  font-size: 1.2rem;
  font-weight: 500;
`;

const Inner = styled.div`
  width: 100%;
  height: 80%;
  margin-top: 30px;
  justify-content: center;
  display: grid;
  grid-template-columns: 400px 400px;
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

const UsersPage = () => {
  // 1. user 불러와서 페이지갯수 정하기
  // 2. button 만들기. 버튼에 클릭 페이지 링크 붙여주기
  // 3. 현재 페이지에 맞는 유저 리스트 호출 ( 페이지 바뀔 때마다 렌더링
  // 4. 현재 페이지에 해당하는 키를 가진 버튼만 컬러 변경

  // 한페이지에 담긴 유저 정보
  const [user, setUser] = useState([]);
  // 페이지 갯수
  const [pageNum, setPageNum] = useState(3);
  axios.get("/users").then((res) => {
    setPageNum(parseInt(res.data.length / 6) + 1);
  });

  // 현재 페이지
  const [page, setPage] = useState(1);
  // api 포인트
  const url = `/users?page=${page}&size=6`;

  useEffect(() => {
    axios
      .get(url)
      .then((res) => {
        setUser(res.data);
        console.log(user);
      })
      .catch((error) => console.log(error));
  }, [url]);

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
    <Container>
      <Nav />
      <Wrapper>
        <StyledHeader>{title}</StyledHeader>
        <Inner>
          {user.map((user) => (
            <UserThumbnail key={user.userId} user={user} />
          ))}
        </Inner>
        <PageList>{pageRender(pageNum, setPage)}</PageList>
      </Wrapper>
      <SideBar />
    </Container>
  );
};

export default UsersPage;
