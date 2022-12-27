import styled from "styled-components";
import Spinner from "../../images/spinner.gif";

const Block = styled.div`
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  width: 100w;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-size: 15px;
  font-weight: 700;
  background-color: rgba(255, 255, 255, 0.8);
  z-index: 9999;
`;

export const Loading = () => {
  return (
    <Block>
      <img src={Spinner} alt="로딩중🔨🔨🔨" width="5%" />
    </Block>
  );
};
