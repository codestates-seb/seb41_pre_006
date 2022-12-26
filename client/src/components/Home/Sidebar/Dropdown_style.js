import styled from 'styled-components';

export const DropdownContainer = styled.nav`
  position: fixed;
  display: flex;
  flex-flow: column nowrap;
  flex-direction: column;
  width: 222px;
  background-color: #ffffff;
  box-shadow: 0 0 12px 2px rgba(0, 0, 0, 0.1);
`;

export const Wrapper = styled.div`
  margin-top: 10px;
  > div {
    color: hsl(210, 8%, 35%);
    font-size: 11px;
    margin: 20px 8px 0px 8px;
  }
  > .side-bar-tabs {
    padding-left: 5px;

    .title {
      font-size: 11px;
      margin-bottom: 5px;
      color: hsl(210, 8%, 45%);
    }

    a {
      color: hsl(210, 8%, 45%);
      font-size: 13px;
      text-decoration: none;

      &.selected {
        p {
          color: hsl(210, 8%, 5%);
          font-weight: bold;
          background-color: hsl(210, 8%, 95%);
          border-right: 3px solid hsl(27, 90%, 55%);
        }
      }

      p {
        display: flex;
        padding: 5px 30px 5px 0px;
        margin-bottom: 5px;
        border-right: 3px solid transparent;
        font-size: 13px;
        gap: 4px;

        &.is-padding {
          padding: 5px 30px 5px 30px;
        }
      }
      :hover {
        border: none;
        color: hsl(210, 8%, 5%);
      }
    }

    > .tab-menu {
      color: hsl(210, 8%, 45%);
      font-size: 13px;
      text-decoration: none;
      display: flex;
      align-items: center;
      height: 34px;
      padding: 0px 0px 4px 0px;
      margin-bottom: 12px;
      :hover {
        border: none;
        color: hsl(210, 8%, 5%);
      }
    }
    > .collectives {
      color: hsl(210, 8%, 45%);
      font-size: 11px;
      display: flex;
      justify-content: space-between;
      margin-bottom: 12px;
      padding-right: 10px;
    }
  }

  > .tab-menu2 {
    color: hsl(210, 8%, 45%);
    font-size: 13px;
    text-decoration: none;
    display: flex;
    align-items: center;
    height: 34px;
    padding: 8px 18px 8px 10px;
    margin: 0;
    gap: 4px;
    :hover {
      border: none;
      color: hsl(210, 8%, 5%);
    }
  }
  > .teams {
    color: hsl(210, 8%, 45%);
    font-size: 11px;
    margin: 24px 8px 10px 10px;
  }
`;

export const Teams = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-size: 13px;
  border-top: 1px solid #e3e6e8;
  border-bottom: 1px solid #e3e6e8;

  > .textbox {
    padding: 10px;
  }

  > .orange-button {
    font-size: 10px;
    color: #ffffff;
    background-color: hsl(27, 90%, 55%);
    padding: 6.6px;
    border: 1px solid transparent;
    box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
    border-radius: 4px;
    width: 139px;
    height: 27.88px;
  }
  > .white-button {
    font-size: 10px;
    color: #6a737c;
    background-color: #ffffff;
    border: none;
    padding: 6.6px;
    width: 139px;
    height: 27.88px;
  }
`;
