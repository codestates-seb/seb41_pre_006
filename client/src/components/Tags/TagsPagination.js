import { useState } from "react";
import Pagination from "react-js-pagination";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import useFetch from "../../hooks/useFetch";
import { getQuestions } from "../../redux/actions/questionsAction";
import { Loading } from "../../Common/Loading";

export const Container = styled.div`
  display: flex;
  flex-wrap: wrap-reverse;
  row-gap: 10px;
  column-gap: 30px;
  justify-content: space-between;
  margin: 20px 0px 0px 10px;
  /* Mobile */
  @media screen and (max-width: 640px) {
    gap: 30px;
    padding-left: 50px;
    margin: 20px 0px 0px -40px;
  }
  > .pagination {
    margin: -10px;
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 5px;
    > li {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 25px;
      height: 27px;
      padding: 0 8px;
      color: hsl(210, 8%, 25%);
      border: 1px solid hsl(210, 8%, 85%);
      border-radius: 3px;
      font-size: 13px;
      cursor: pointer;
      :hover {
        background-color: hsl(210, 8%, 85%);
      }
    }
    & > li.active {
      border: none;
      color: #ffffff;
      background-color: hsl(27, 90%, 55%);
      cursor: default;
    }
    & > li:first-child,
    & > li:last-child {
      display: none;
      width: 50px;
    }
    & > li:nth-child(2),
    & > li:nth-last-child(2) {
      width: 50px;
    }
  }

  > .btn-per-page {
    display: flex;
    justify-content: row;
    button {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 32px;
      height: 27px;
      margin: 0 2px;
      padding: 0 8px;
      color: hsl(210, 8%, 25%);
      border: 1px solid hsl(210, 8%, 85%);
      border-radius: 3px;
      font-size: 13px;
      cursor: pointer;
      :hover {
        background-color: hsl(210, 8%, 85%);
      }
      &.btn-active {
        border: none;
        color: #ffffff;
        background-color: hsl(27, 90%, 55%);
        cursor: default;
      }
    }
    p {
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 13px;
      color: hsl(210, 8%, 25%);
      margin: 0 2px;
      padding: 0 8px;
    }
  }
`;

export const Box = styled.div`
  display: flex;
  flex-wrap: wrap-reverse;
  row-gap: 10px;
  column-gap: 30px;
  justify-content: space-between;
  margin: 20px 0;
  /* Mobile */
  @media screen and (max-width: 640px) {
    gap: 30px;
  }
  > .pagination {
    margin: -10px;
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 5px;
    > li {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 25px;
      height: 27px;
      padding: 0 8px;
      color: hsl(210, 8%, 25%);
      border: 1px solid hsl(210, 8%, 85%);
      border-radius: 3px;
      font-size: 13px;
      cursor: pointer;
      :hover {
        background-color: hsl(210, 8%, 85%);
      }
    }
    & > li.active {
      border: none;
      color: #ffffff;
      background-color: hsl(27, 90%, 55%);
      cursor: default;
    }
    & > li:first-child,
    & > li:last-child {
      display: none;
      width: 50px;
    }
    & > li:nth-child(2),
    & > li:nth-last-child(2) {
      width: 50px;
    }
  }
`;

export const TagsPagination = () => {
  const dispatch = useDispatch();
  const [isLoading, setIsLoading] = useState(false);

  let { page, size, totalElements, totalPages } = useSelector(
    (state) => state.questionsReducer.pageInfo
  );

  // ✨ 페이지네이션
  const [currentPage, setCurrentPage] = useState(page); // 현재 페이지 번호
  const [perPageCount, setPerPageCount] = useState(size); // 페이지 당 글 개수

  const perPageCountList = [10, 15, 20];

  const HandleCurrentPageChange = async (e) => {
    setIsLoading(true);
    setCurrentPage(e);

    const res = await useFetch(
      "GET",
      `/articles?page=${e}&size=${perPageCount}`
    ).finally(() => {
      setIsLoading(false);
    });

    dispatch(getQuestions(res));
  };

  const PerPageCountClick = async (e) => {
    setIsLoading(true);
    setPerPageCount(Number(e.target.value));

    const res = await useFetch(
      "GET",
      `/articles?page=${currentPage}&size=${e.target.value}`
    ).finally(() => {
      setIsLoading(false);
    });

    dispatch(getQuestions(res));
  };

  return (
    <Container>
      <Pagination
        activePage={currentPage}
        itemsCountPerPage={size}
        // 한 페이지 당 20개 * 5페이지 = 100
        totalItemsCount={totalElements}
        pageRangeDisplayed={totalPages}
        onChange={HandleCurrentPageChange}
        prevPageText="Prev"
        nextPageText="Next"
      />
      <div className="btn-per-page">
        {perPageCountList.map((el, idx) => {
          return (
            <button
              key={idx}
              value={el}
              className={el === perPageCount ? "btn-active" : ""}
              onClick={PerPageCountClick}
            >
              {el}
            </button>
          );
        })}
        <p>per page</p>
      </div>
      {isLoading && <Loading />}
    </Container>
  );
};
