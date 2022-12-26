import styled from 'styled-components';

export const RightSideWidget = styled.div`
  display: flex;
  flex-direction: column;
  width: 302px;
  margin-bottom: 20px;
`;

export const RightSidebar = styled.div`
  border-right: 1px solid hsl(47, 65%, 84%);
  border-bottom: 1px solid hsl(47, 65%, 84%);
  border-left: 1px solid hsl(47, 65%, 84%);
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
