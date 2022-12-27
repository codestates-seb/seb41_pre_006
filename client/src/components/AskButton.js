import styled from "styled-components";
import { Link } from "react-router-dom";

const Button = styled(Link)`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 108px;
  height: 34px;
  padding: 0.6rem;
  background-color: #0a95ff;
  color: #fff;
  font-size: 14px;
  border: none;
  border-radius: 4px;
  &:hover {
    background-color: #0074cc;
  }
  &:active {
    background-color: #0063bf;
  }
`;

const AskButton = () => {
  return (
    <Button>
      <Link to={"/questions/ask"}>Ask&nbsp;Qustion</Link>
    </Button>
  );
};

export default AskButton;
