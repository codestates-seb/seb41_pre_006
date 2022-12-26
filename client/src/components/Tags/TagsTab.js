import styled from "styled-components";
import { AiOutlineSearch } from "react-icons/ai";
import { useState } from "react";

const FilterContainer = styled.div`
  display: flex;
  justify-content: space-between;
  flex-direction: row;
  margin-top: 18px;
  padding: 0;
  flex-flow: wrap;
  @media screen and (max-width: 982px) {
    display: flex;
    row-gap: 12px;
  }
  > .input-search {
    display: flex;
    max-width: calc(4rem * 3);
    margin: 0;
    flex-direction: row;
    align-items: stretch;
    height: 100%;
    flex-wrap: nowrap;
    flex-shrink: 10000;
    flex-grow: 1;
    position: relative;
    padding: 5px 5px;
    background-color: #ffffff;
    border: 1px solid #babfc4;
    border-radius: 4px;
    box-sizing: inherit;
    &:focus-within {
      box-shadow: 0px 0px 3px 3px rgba(107, 186, 247, 0.5);
      border: none;
      outline: 0;
    }

    > input {
      font-size: 12px;
      width: 100%;
      flex-grow: 1;
      height: 14.994px;
      border: none;
      :focus {
        outline: none;
      }
    }
  }
  > .sort {
    /* 우측 정렬 */
    margin-bottom: 12px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    @media screen and (max-width: 640px) {
      font-size: 15.4px;
      flex-direction: column !important;
      align-items: flex-start;
      gap: 10px;
      margin-bottom: 10px;
    }
    > .question-sort {
      margin-bottom: 12px;
      > button {
        font-size: 12px;
        border: 1px solid hsl(210, 8%, 55%);
        padding: 8px 10px;
        color: hsl(210, 8%, 45%);
        @media screen and (max-width: 640px) {
          height: 35.44px;
          padding-left: 0.4em;
          padding-right: 0.4em;
          flex-direction: column-reverse;
        }
        cursor: pointer;
        :first-child {
          border-radius: 3px;
          border-top-right-radius: 0;
          border-bottom-right-radius: 0;
        }
        :last-child {
          border-radius: 3px;
          border-top-left-radius: 0;
          border-bottom-left-radius: 0;
        }
        :not(:last-child) {
          border-right: none;
        }
        :hover {
          background-color: hsl(210, 8%, 97.5%);
        }
        &.is-selected {
          background-color: hsl(210, 8%, 90%);
          color: hsl(210, 8%, 25%);
          border: 1px solid hsl(210, 8%, 55%);
          :not(:last-child) {
            border-right: none;
          }
        }
      }
    }
  }
`;
export const TagsTab = () => {
  // ✨ 정렬
  const [selected, setSelected] = useState("Popular");
  // redux?
  const sortClick = (e) => {
    switch (e.target.value) {
      case "Popular":
        setSelected("Popular");
        break;
      case "Name":
        setSelected("Name");
        break;
      case "New":
        setSelected("New");
        break;
      default:
        break;
    }
  };
  return (
    <FilterContainer>
      <div className="input-search">
        <AiOutlineSearch size={20} color="#838C95" />
        <input
          type="text"
          className="logo-search"
          placeholder="Filter by tag name"
        />
      </div>
      <div className="sort">
        <div className="question-sort">
          <button
            onClick={sortClick}
            className={selected === "Popular" ? "is-selected" : ""}
            value={"Popular"}
          >
            Popular
          </button>
          <button
            onClick={sortClick}
            className={selected === "Name" ? "is-selected" : ""}
            value={"Name"}
          >
            Name
          </button>
          <button
            onClick={sortClick}
            className={selected === "New" ? "is-selected" : ""}
            value={"New"}
          >
            New
          </button>
        </div>
      </div>
    </FilterContainer>
  );
};
