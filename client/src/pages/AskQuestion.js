import { useState } from "react";
import styled from "styled-components";

// 태그는 TagList에 배열로 저장됨

const Main = styled.div`
  display: flex;
  flex-direction: column;
  height: auto;
  background-color: #eff0f1;
  color: #232629;
`;
const Title = styled.div`
  margin-top: 50px;
  margin-bottom: 50px;
  margin-left: 30px;
  font-weight: 600;
  font-size: 1.4rem; ;
`;
const QueGuide = styled.div`
  width: 70%;
  display: block;
  margin-left: 30px;
  margin-bottom: 30px;
  background-color: #e7f1fa;
  border: solid 2px #98c2e8;
  border-radius: 5px;
  color: #3b4045;
  .title {
    font-weight: 500;
    font-size: 1rem;
    margin: 20px;
  }
  .step {
    margin: 20px auto 10px 20px;
    font-size: 1rem;
  }
  & p {
    margin-left: 20px;
    font-size: 0.7rem;
    line-height: 0.9rem;
  }
  & ul {
    margin-bottom: 20px;
    font-size: 0.7rem;
  }
  & li {
    margin: 10px auto auto 40px;
    list-style-type: disc;
  }
`;

const Form = styled.div`
  width: 70%;
  height: ${(props) => props.height};
  display: flex;
  flex-direction: column;
  margin-left: 30px;
  margin-bottom: 30px;
  padding: 32px;
  border: solid 2px #cccccc;
  border-radius: 6px;
  background-color: white;
  & h1 {
    font-size: 1rem;
    margin-bottom: 8px;
  }
  & p {
    margin-bottom: 8px;
    font-size: 0.7rem;
    font-weight: 300;
  }
  .textForm {
    /* margin-left: 20px; */
    width: 100%;
    height: ${(props) => props.inHeight};
    border: solid 2px #cccccc;
    border-radius: 4px;
    font-size: 16px;
    line-height: 300;
    border-radius: 4px;
    padding: 8px;
  }
`;
const Tag = styled.div`
  width: 100%;
  display: flex;
  align-items: flex-start;
  border: solid 2px #cccccc;
  padding: 8px;
  /* margin-left: 20px; */
  > ul {
    display: flex;
    flex-wrap: wrap;
    padding: 0;
    margin: 0 0 0 0;
  }
  & li {
    display: flex;
    width: auto;
    padding: 0 8px;
    margin-right: 8px;
    justify-content: center;
    align-items: center;
    border: solid 2px #5499c7;
    border-radius: 3px;
    background-color: #d6eaf8;
    /* height: 30px; */
    /* margin: 8px 8px 8px 8px; */
    > span {
      /* margin-top: 5px; */
      color: #5499c7;
      font-weight: 400;
      font-size: 0.8rem;
    }
    > .xicon {
      margin-left: 5px;
      line-height: 24px;
    }
  }
  > input {
    flex: 1;
    border: none;
    font-size: 0.8rem;
    font-weight: 300;
    line-height: 24px;
    /* margin-top: 2px; */
    /* padding: 4px 0 0 10px; */
    /* height: 40px; */
  }
`;
const Button = styled.button`
  background-color: #2d7fff;
  /* width: 180px; */
  height: 50px;
  border-radius: 4px;
  margin: auto auto 30px 30px;
  color: white;
  font-size: 0.7rem;
  padding: 12px 24px;
`;

function AskQuestionPage() {
  const TagList = [];
  const [tags, setTags] = useState(TagList);

  const addTags = (e) => {
    if (e.length !== 0) {
      setTags([...tags, e]);
    }
  };

  const removeTags = (e) => {
    let filtering = tags.filter((el, index) => index !== e);
    setTags(filtering);
  };

  return (
    <Main>
      <Title>Ask a public question</Title>
      <QueGuide>
        <p className="title">Writing a good question</p>
        <p>
          You’re ready to ask a programming-related question and this form will
          help guide you through the process.
        </p>
        <p>
          Looking to ask a non-programming question? See the topics here to find
          a relevant site.
        </p>
        <p className="step">Steps</p>
        <ul>
          <li>Summarize your problem in a one-line title.</li>
          <li>Describe your problem in more detail.</li>
          <li>Describe what you tried and what you expected to happen.</li>
          <li>
            Add “tags” which help surface your question to members of the
            community.
          </li>
          <li>Review your question and post it to the site.</li>
        </ul>
      </QueGuide>
      <Form height="150px" inHeight="40px">
        <h1>Title</h1>
        <p>
          Be specific and imagine you’re asking a question to another person.
        </p>
        <input
          className="textForm"
          placeholder="e.g. Is there an R function for fiding the index of an element in a vector?"
        ></input>
      </Form>
      <Form height="350px" inHeight="230px">
        <h1>What are the details of your problem?</h1>
        <p>Introduce the problem and expand on what you put in the title. </p>
        <input className="textForm" height="200px"></input>
      </Form>
      <Form height="350px" inHeight="230px">
        <h1>What did you try and what were you expecting?</h1>
        <p>
          Describe what you tried, what you expected to happen, and what
          actually resulted.
        </p>
        <input className="textForm"></input>
      </Form>
      <Form height="160px" inHeight="40px">
        <h1>Tags</h1>
        <p>
          Add up to 5 tags to describe what your question is about. Start typing
          to see suggestions.
        </p>
        <Tag>
          <ul>
            {tags.map((tag, index) => (
              <li key={index}>
                <span>{tag}</span>
                <span className="xicon" onClick={() => removeTags(index)}>
                  x
                </span>
              </li>
            ))}
          </ul>
          <input
            placeholder="e.g. (asp.net wordpress mongodb)"
            className="tag-input"
            onKeyUp={(e) => {
              if (e.key === "Enter") {
                addTags(e.target.value);
                e.target.value = null;
              } else if (e.key === "Backspace") {
              }
            }}
          ></input>
        </Tag>
      </Form>
      <Button>Review your question</Button>
    </Main>
  );
}

export default AskQuestionPage;
