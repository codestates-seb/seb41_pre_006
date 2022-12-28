import styled from "styled-components";
import React from "react";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
// 해당 훅이 사용되지 않아 컴파일 문제로 잠시 주석처리해두었습니다. 💕

const Main = styled.div`
  display: flex;
  background-color: #eff0f1;
  height: 900px;
  justify-content: center;
  flex-direction: row;
`;
const Explanation = styled.div`
  width: 400px;
`;

const Block = styled.div`
  display: flex;
  margin-top: 300px;
  flex-direction: column;
`;
const ExTitle = styled.span`
  font-weight: 600;
  font-size: 1.4rem;
`;
const ExDetail = styled.span`
  font-size: 0.8rem;
  margin-top: 20px;
`;

const SocialSignupContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 0;
  width: 350px;
  height: 20%;
  margin-top: 100px;
  font-size: 0.7rem;
`;

const SignupContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 350px;
  height: 450px;
  background-color: white;
  border-radius: 5%;
  box-shadow: -1px 1px 10px 2px #dcdcdc;
  font-size: 0.7rem;
  font-weight: 300;
`;

const SocialButton = styled.button`
  width: 100%;
  margin: 0.5em;
  height: 40px;
  border-radius: 7px;
  background-color: ${(props) => props.color};
  color: ${(props) => props.fontcolor};
  font-size: 1em;
  border-color: #dcdcdc;
`;
const Button = styled.button`
  background-color: #2d7fff;
  border: none;
  width: 80%;
  height: 40px;
  margin-left: 35px;
  border-radius: 4px;
  text-align: center;
  color: white;
  font-size: 1.2em;
  font-weight: 300;
`;
const Input = styled.input`
  margin-left: 35px;
  width: 80%;
  height: 10%;
  padding: 8px 32px 8px 9px;
  border: 1px solid #babfc4;
  font-size: 16px;
  line-height: 300;
  border-radius: 4px;
`;

const Div = styled.div`
  font-weight: 500;
  margin-top: 30px;
  margin-bottom: 5px;
  margin-left: 35px;
`;
const Span = styled.div`
  margin: 10px 0 10px 35px;
  width: 80%;
  font-size: 14px;
  color: #6a737c;
`;
function SignupPage() {
  //가입 버튼 함수
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    let body = {
      email: email,
      name: name,
      password: password,
      description: "",
      location: "",
    };
    let config = {
      method: "post",
      url: "/users",
      headers: {},
      data: body,
    };
    axios(config)
      .then((res) => {
        if (res.status === 201) {
          console.log(JSON.stringify(res.data));
          console.log("성공");
          alert("가입성공");
        }
      })
      .then(navigate("/users/login"))
      .catch((error) => {
        console.log(error);
        alert("이미 가입된 이메일입니다");
      });
  };
  return (
    <Main>
      {/*좌측 가입시 혜택 설명문 컨테이너 */}
      <Explanation>
        <Block>
          <ExTitle>Join the Stack Overflow community</ExTitle>
          <ExDetail>Get unstuck - ask a question</ExDetail>
          <ExDetail>Unlock new privileges like voting and commenting</ExDetail>
          <ExDetail>Save your favorite tags, filters, and jobs</ExDetail>
          <ExDetail>Earn reputation and badges</ExDetail>
        </Block>
      </Explanation>
      {/*우측 가입 정보 기입 컨테이너 */}
      <Explanation>
        <SocialSignupContainer>
          <SocialButton color="white">Sign up with Google</SocialButton>
          <SocialButton color="#23262A" fontcolor="white">
            Sign up with GitHub
          </SocialButton>
          <SocialButton color="#293D83" fontcolor="white">
            Sign up with Facebook
          </SocialButton>
        </SocialSignupContainer>
        <SignupContainer>
          <form onSubmit={handleSubmit}>
            <Div>Display name</Div>
            <Input onChange={(e) => setName(e.target.value)}></Input>
            <Div>Email</Div>
            <Input
              type="text"
              onChange={(e) => setEmail(e.target.value)}
            ></Input>
            <Div>Password</Div>
            <Input
              type="password"
              onChange={(e) => setPassword(e.target.value)}
            ></Input>
            <Span>
              Passwords must contain at least eight characters, including at
              least 1 letter and 1 number.
            </Span>
            <Button type="submit">Sign up</Button>
          </form>
        </SignupContainer>
      </Explanation>
    </Main>
  );
}

export default SignupPage;
