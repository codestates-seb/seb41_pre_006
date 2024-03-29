// FE memo ---
// components vs pages
// 1. 여러 페이지에서 동시에 사용되는 컴포넌트의 경우 components 폴더에서 관리
// 2. 페이지 컴포넌트의 경우 pages 폴더에서 관리
// 3. 해당 페이지 내에서만 사용하는 컴포넌트의 경우 해당 페이지 폴더 하위에서 관리하는 것이 좋음!
import axios from "axios";
import { useState } from "react";
import styled from "styled-components";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { getLoginStatus } from "../redux/actions/userAction";
import useFetch from "../hooks/useFetch";
const Main = styled.div`
  display: flex;
  background-color: #eff0f1;
  justify-content: center;
`;
const LoginContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 10%;
  padding: 0;
  width: 300px;
  height: 570px;
`;
const SocialLoginContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 0;
  width: 100%;
  height: 30%;
`;

const MainLoginContainer = styled.div`
  display: flex;
  flex-direction: column;
  /* justify-content: space-between; */
  width: 100%;
  height: 50%;
  background-color: white;
  border-radius: 5%;
  box-shadow: -1px 1px 10px 2px #dcdcdc;
  margin-top: 1em;
  padding: 32px;
`;

const HelpContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  text-align: center;
  margin-top: 2em;
  font-size: 14px;
  font-weight: 300;
  line-height: 18px;
`;

const Box = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  text-align: left;
  font-weight: 500;
  font-size: 0.7rem;
  margin-bottom: 8px;
  /* margin-top: 1.5em; */
  /* margin-left: 2em; */
`;
const Input = styled.input`
  width: 100%;
  height: 18%;
  /* margin-top: 1em; */
  border-radius: 4px;
  border: 1px solid #dcdcdc;
  margin-bottom: 16px;
`;

const Button = styled.button`
  background-color: #2d7fff;
  border: none;
  width: 100%;
  height: 40px;
  margin-top: 2em;
  border-radius: 4px;
  text-align: center;
  color: white;
  font-size: 0.8em;
  font-weight: 300;
`;
const SocialButton = styled.button`
  width: 100%;
  margin: 0.5em;
  height: 40px;
  border-radius: 7px;
  background-color: ${(props) => props.color};
  color: ${(props) => props.fontcolor};
  font-size: 0.8em;
  border-color: #dcdcdc;
  font-weight: 300;
`;

function LoginPage() {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const HandleSubmit = async (e) => {
    e.preventDefault();
    const body = {
      username: email,
      password: password,
    };
    const res = await useFetch("POST", "/login", body);
    if (res === 200) {
      dispatch(getLoginStatus({ isLogin: true }));
    }
    navigate("/");

    //   axios
    //     .post("/login", body, { withCredentials: true })
    //     .then((res) => {
    //       axios.defaults.headers.common[
    //         "Authorization"
    //       ] = `Bearer ${res.data.access_token}`;
    //       return res.data;
    //     })
    //     .then(dispatch(getLoginStatus({ isLogin: true })))
    //     .then(navigate("/"));
  };

  return (
    <Main>
      <LoginContainer>
        <SocialLoginContainer>
          <SocialButton color="white">Log in with Google</SocialButton>
          <SocialButton color="#23262A" fontcolor="white">
            Log in with GitHub
          </SocialButton>
          <SocialButton color="#293D83" fontcolor="white">
            Log in with Facebook
          </SocialButton>
        </SocialLoginContainer>
        <MainLoginContainer>
          <form onSubmit={HandleSubmit}>
            <Box>Email</Box>
            <Input
              id="id"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            ></Input>
            <Box>Password</Box>
            <Input
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            ></Input>
            <Button type="submit">Log in</Button>
          </form>
        </MainLoginContainer>
        <HelpContainer>
          <span>Don't have an account? Sign up</span>
          <span>Are you an employer? Sign up on Talent</span>
        </HelpContainer>
      </LoginContainer>
    </Main>
  );
}
export default LoginPage;
