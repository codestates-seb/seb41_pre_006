import styled from "styled-components";
import { ReactComponent as ProfIcon } from "./images/profileicon.svg";

const UserBox = styled.div`
  width: 300px;
  height: 97px;
  padding: 20px;
  display: flex;
  flex-direction: row;
`;
const Info = styled.div`
  display: flex;
  margin-left: 20px;
  flex-direction: column;
  > h1 {
    font-size: 1.2em;
    margin-bottom: 15px;
    color: navy;
  }
  > span {
    font-size: 0.9em;
    margin-bottom: 5px;
  }
`;

const UserThumbnail = ({ user }) => {
  return (
    <UserBox>
      <div>
        <ProfIcon width="50" height="50" />
      </div>
      <Info>
        <h1>{user.name}</h1>
        <span>{user.location}</span>
        <span>{user.description}</span>
      </Info>
    </UserBox>
  );
};

export default UserThumbnail;
