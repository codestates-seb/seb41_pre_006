import Pagination from "react-js-pagination";
import "../components/paging.css";

// 페이지네이션 데모 🥹

export const Paging = ({ page, count, setPage }) => {
  return (
    <Pagination
      activePage={page}
      itemsCountPerPage={7}
      totalItemsCount={count}
      pageRangeDisplayed={5}
      prevPageText={"‹"}
      nextPageText={"›"}
      onChange={setPage}
    />
  );
};
