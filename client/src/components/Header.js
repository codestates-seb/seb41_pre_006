import styled from "styled-components";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getLoginStatus } from "../redux/actions/userAction";
// import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// import { faStackOverflow } from "@fortawesome/free-solid-svg-icons";
// <FontAwesomeIcon icon={faStackOverflow} size="2x/>

const StyledHeader = styled.header`
  z-index: 7000;
  position: fixed !important;
  display: flex;
  min-width: auto;
  width: 100vw;
  height: 54px !important;
  padding: 0 8px;
  align-items: center;
  align-content: center;
  justify-content: space-between;
  color: #000;
  font-size: 24px;
  background-color: #f8f9f9;
  border-top: 3px solid #f48225;
  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
    0 2px 8px hsla(0, 0%, 0%, 0.05);
`;

const LogoLink = styled(Link)`
  line-height: 54px;
  color: #000;
  font-size: 22px;
  letter-spacing: -0.5px;
  text-decoration: none;
  box-sizing: border-box;
  svg {
    font-weight: 400;
  }
  b {
    font-weight: 600;
  }
  span {
    font-weight: 300;
    display: inline-block;
  }
`;

const SearchInput = styled.input`
  margin: 0 16px;
  width: 50vw;
  border: 1px solid #babfc4;
  background: #fff;
  padding: 4px;
  border-radius: 3px;
  box-sizing: border-box;
`;

/* const ProfileLink = styled.a`
  margin-right: 8px;
  color: #000;
  font-size: 16px;
  text-decoration: none;
`; */

const LogInButton = styled(Link)`
  margin-right: 8px;
  padding: 0.4rem;
  background-color: #e1ecf4;
  color: #39739d;
  font-size: 14px;
  font-weight: 300;
  border: 1px solid #7aa7c7;
  border-radius: 4px;
  &:hover {
    background-color: #cde9fe;
  }
  &:active {
    background-color: #cde9fe;
  }
`;

const SignUpButton = styled(Link)`
  padding: 0.4rem;
  background-color: #0a95ff;
  color: #fff;
  font-size: 14px;
  font-weight: 300;
  border: none;
  border-radius: 4px;
  &:hover {
    background-color: #0074cc;
  }
  &:active {
    background-color: #0063bf;
  }
`;

const Header = () => {
  const user = useSelector((state) => state.userReducer);
  const dispatch = useDispatch();

  // 로그아웃 핸들러
  const logoutHandler = () => {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
    dispatch(getLoginStatus({ isLogin: false }));

    window.location.reload();
  };
  return (
    <StyledHeader>
      <LogoLink to={"/"} className="logo">
        <span>stack</span>
        <b>overflow</b>
      </LogoLink>
      <form action="" className="search">
        <SearchInput type="text" placeholder="searh..." />
      </form>
      {/* <ProfileLink href="" className="profile">
        kimcoding
      </ProfileLink> */}
      <div>
        {user.isLogin ? (
          <LogInButton onClick={logoutHandler} className="LogInButton">
            Log Out
          </LogInButton>
        ) : (
          <LogInButton to={"/users/login"} className="LogInButton">
            Log in
          </LogInButton>
        )}
        <SignUpButton to={"/users/signup"} className="SignUpButton">
          Sign up
        </SignUpButton>
      </div>
    </StyledHeader>
  );
};

export default Header;
