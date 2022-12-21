import styled from "styled-components";
// import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// import { faStackOverflow } from "@fortawesome/free-solid-svg-icons";
// <FontAwesomeIcon icon={faStackOverflow} size="2x/>

const StyledHeader = styled.header`
  min-width: auto;
  width: 100vw;
  background-color: #f8f9f9;
  border-top: 3px solid #f48225;
  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
    0 2px 8px hsla(0, 0%, 0%, 0.05);
  color: #000;
  font-size: 24px;
  display: grid;
  grid-template-columns: 200px 1fr 200px;
  align-items: center;
  align-content: center;
  padding: 0 8px;
  z-index: 7000;
`;

const LogoLink = styled.a`
  color: #000;
  text-decoration: none;
  display: inline-block;
  height: 50px;
  line-height: 58px;
  box-sizing: border-box;
  svg {
    font-weight: normal;
  }
  b {
    font-weight: bold;
  }
  span {
    display: inline-block;
    /* padding: 4px; */
  }
`;

const SearchInput = styled.input`
  width: 80%;
  border: 1px solid #babfc4;
  background: #fff;
  padding: 4px;
  border-radius: 3px;
  box-sizing: border-box;
`;

const ProfileLink = styled.a`
  text-decoration: none;
  color: #000;
  font-size: 16px;
`;

const Header = () => {
  return (
    <StyledHeader>
      <LogoLink href="" className="logo">
        <span>stack</span>
        <b>overflow</b>
      </LogoLink>
      <form action="" className="search">
        <SearchInput type="text" placeholder="searh..." />
      </form>
      <ProfileLink href="" className="profile">
        kimcoding
      </ProfileLink>
    </StyledHeader>
  );
};

export default Header;
