import styled from "styled-components";

const StyledQustionRow = styled.div`
  background-color: beige;
  padding: 10px 16px 10px;
  display: grid;
  grid-template-columns: repeat(3, 50px) 1fr;
  border-top: 1px solid #d3d3d3;
`;

const QustionStat = styled.div`
  text-align: center;
  display: inline-block;
  font-size: 1.2rem;
  color: #000;
  span {
    margin-top: 4px;
    display: block;
    font-weight: 400;
    font-size: 0.7rem;
  }
`;

const QustionTitleArea = styled.div`
  padding: 0 30px;
`;

const QustionLink = styled.a`
  text-decoration: none;
  font-size: 1.2rem;
  display: block;
  margin-bottom: 4px;
`;

const Tag = styled.a`
  display: inline-block;
  padding: 2px 4px;
  border-radius: 4px;
  margin-right: 3px;
  color: #39739d;
  background-color: #e1ecf4;
  font-size: 0.7rem;
`;

const WhoAndWhen = styled.div`
  display: flex;
  color: #aaa;
  font-size: 0.8rem;
  justify-content: flex-end;
  padding: 10px 0;
`;

const UserLink = styled.div`
  margin-right: 8px;
  color: #0074cc;
`;

function QustionRow() {
  return (
    <StyledQustionRow>
      <QustionStat>
        0<span>vote</span>
      </QustionStat>
      <QustionStat>
        3<span>answers</span>
      </QustionStat>
      <QustionStat>
        8<span>views</span>
      </QustionStat>
      <QustionTitleArea>
        <div>
          <QustionLink>질문 합니다..</QustionLink>
          <Tag>java</Tag>
          <Tag>js</Tag>
          <Tag>literals</Tag>
        </div>
        <WhoAndWhen>
          <UserLink>kim coding</UserLink>1 asked 30mins age
        </WhoAndWhen>
      </QustionTitleArea>
    </StyledQustionRow>
  );
}

export default QustionRow;
