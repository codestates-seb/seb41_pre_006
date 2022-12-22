// FE memo ---
// components vs pages
// 1. 여러 페이지에서 동시에 사용되는 컴포넌트의 경우 components 폴더에서 관리
// 2. 페이지 컴포넌트의 경우 pages 폴더에서 관리
// 3. 해당 페이지 내에서만 사용하는 컴포넌트의 경우 해당 페이지 폴더 하위에서 관리하는 것이 좋음!
import styled from "styled-components";

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
  heigjt: 30%;
`;

const MainLoginContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 50%;
  background-color: white;
  border-radius: 5%;
  box-shadow: -1px 1px 10px 2px #dcdcdc;
  margin-top: 1em;
`;

const HelpContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  text-align: center;
  margin-top: 2em;
`;

const Box = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  text-align: left;
  font-weight: 500;
  margin-top: 1.5em;
  margin-left: 2em;
`;
const EmailInput = styled.input`
  width: 80%;
  height: 13%;
  margin-top: 1em;
  border-radius: 4px;
  border-color: #dcdcdc;
`;
const PasswordInput = styled.input`
  width: 80%;
  height: 13%;
  margin-top: 1em;
  border-radius: 4px;
  border-color: #dcdcdc;
`;
const Button = styled.button`
  background-color: #2d7fff;
  border: none;
  width: 85%;
  height: 40px;
  margin-top: 1.3em;
  border-radius: 4px;
  text-align: center;
  color: white;
  font-size: 1.2em;
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

function LoginPage() {
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
          <form>
            <Box>Email</Box>
            <EmailInput></EmailInput>
            <Box>Password</Box>
            <PasswordInput></PasswordInput>

            <Button>Log in</Button>
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
