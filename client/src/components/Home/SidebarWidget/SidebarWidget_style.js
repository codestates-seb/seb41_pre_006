import styled from 'styled-components';

export const RightSide = styled.div`
  /* margin 사이즈 수정 가능 */
  padding: 24px 0;
  margin-left: 24px;
  display: flex;
  flex-direction: column;
  width: 302px;
  // Mobile
  @media screen and (max-width: 981px) {
    display: none;
  }
`;

export const RightSidebar = styled.div`
  border: 1px solid hsl(47, 65%, 84%);
  background-color: hsl(47, 83%, 91%);
  color: #525960;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), 0 1px 2px rgba(0, 0, 0, 0.05),
    0 2px 8px rgba(0, 0, 0, 0.05);

  header {
    padding: 12px 15px;
    border-bottom: 1px solid hsl(47, 65%, 84%);
    font-size: 12px;
    font-weight: 650;
  }

  & > header:nth-child(3) {
    border-top: 1px solid hsl(47, 65%, 84%);
  }

  ul {
    padding: 4px 15px;
    background-color: hsl(47, 87%, 94%);
  }
  li {
    margin: 12px 0 12px 20px;
    font-size: 13px;
    list-style: circle;
  }
`;
