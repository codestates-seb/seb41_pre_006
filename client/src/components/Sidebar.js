import styled from "styled-components";

const S_SideBar = styled.div`
  font-size: 14px;
  margin-left: 24px;
  float: right;
  width: 300px;
  margin: 0 0 15px;
`;

const S_SideBarWidget = styled.div`
  margin-bottom: 16px;
  border-color: hsl(47, 65%, 84%);
  background-color: hsl(47, 87%, 94%);
  border: 1px solid hsl(47, 87%, 94%);
  border-radius: 3px;
`;

const S_SideHead = styled.li`
  border-color: hsl(47, 65%, 84%);
  background-color: hsl(47, 83%, 91%);
  font-size: 12px;
  font-weight: bold;
  color: hsl(210, 8%, 35%) !important;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  display: flex !important;
  border-bottom-width: 1px;
  padding: 12px 15px;
`;

const S_SideItem = styled.li`
  display: flex !important;
  padding: 0 16px;
  margin: 12px 0;
`;

const S_ItemShrink = styled.div`
  flex-shrink: 0 !important;
  flex-basis: 8.33333333%;
  padding-top: 1px;
  svg {
    vertical-align: text-top !important;
  }
`;

const S_ItemWord = styled.div`
  min-width: 0 !important;
  overflow-wrap: break-word !important;
`;

const S_FaviconStack = styled.div`
  display: inline-block;
  background-position: 0 -6120px;
  &.flow {
    background-position: 0 -6156px;
  }
  width: 16px;
  height: 16px;
  background-color: transparent;
  background-repeat: no-repeat;
  background-size: 16px;
  background-image: url("https://cdn.sstatic.net/Img/favicons-sprite16.png?v=22475cccbf39");
`;

const S_SideBarWidgetReg = styled.div`
  word-wrap: break-word;
  margin-bottom: 16px !important;
  position: relative;
  border: 1px solid hsl(210, 8%, 85%);
  border-radius: 3px;
  h2 {
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
    font-size: 15px;
    padding: 12px 16px;
    background: hsl(210, 8%, 97.5%);
    color: hsl(210, 8%, 35%);
    margin: 0;
  }
  ul {
    display: block;
    padding: 4px 15px;
    border-top: 1px solid hsl(210, 8%, 90%);
    list-style-type: disc;
    li {
      display: flex;
      color: hsl(210, 8%, 65%) !important;
      margin: 12px 0;
      a {
        display: inline;
        padding: 0;
        border: none;
        border-radius: 0;
        outline: initial;
        font: inherit;
        background: none;
        box-shadow: none;
        text-align: inherit;
        text-decoration: none;
        color: hsl(206, 100%, 40%);
        cursor: pointer;
        user-select: auto;
      }
    }
  }
`;

const S_SideBarWidget_Content = styled.div`
  display: flex;
  flex-direction: column !important;
  padding: 16px 15px;
  border-top: hsl(210, 8%, 90%);
  position: relative;
  border-top: 1px solid hsl(210, 8%, 89%);
  border-radius: 3px;
`;

const S_ShowAddWatch = styled.div`
  display: flex !important;
  text-align: center !important;
  margin-left: auto !important;
  margin-right: auto !important;
  align-items: center !important;
  flex-direction: column !important;
  margin: calc(16px / 2 * -1);
  div {
    margin: 8px 0;
    svg {
      fill: hsl(206, 85%, 57.5%);
    }
  }
  p {
    margin: 8px 0;
    max-width: 210.66px;
    color: hsl(210, 8%, 45%);
    clear: both;
  }
  a {
    font-size: 12px;
    margin: 8px 0;
    color: hsl(205, 47%, 42%);
    background-color: hsl(205, 46%, 92%);
    border-color: hsl(205, 41%, 63%);
    box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 70%);
    position: relative;
    display: inline-block;
    padding: 0.8em;
    border: 1px solid hsl(205, 41%, 63%);
    border-radius: 3px;
    line-height: calc((13 + 2) / 13);
    text-align: center;
    user-select: none;
    svg {
      vertical-align: baseline;
      margin-top: -0.3em;
      margin-bottom: -0.3em;
      transition: opacity 200ms cubic-bezier(0.165, 0.84, 0.44, 1);
      fill: hsl(205, 47%, 42%);
      margin-right: 3px;
    }
  }
`;

function SideBar() {
  return (
    <S_SideBar>
      <S_SideBarWidget>
        <ul>
          <S_SideHead>The Overflow Blog</S_SideHead>
          <S_SideItem>
            <S_ItemShrink>
              <svg
                aria-hidden="true"
                width="14"
                height="14"
                viewBox="0 0 14 14"
              >
                <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
              </svg>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                A flight simulator for developers to practice real world
                challenges and...
              </a>
            </S_ItemWord>
          </S_SideItem>
          <S_SideItem>
            <S_ItemShrink>
              <svg
                aria-hidden="true"
                width="14"
                height="14"
                viewBox="0 0 14 14"
              >
                <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
              </svg>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                Goodbye Webpack, hello Turbopack! The big news from today’s
                Next.JS conference
              </a>
            </S_ItemWord>
          </S_SideItem>
          <S_SideHead>Featured on Meta</S_SideHead>
          <S_SideItem>
            <S_ItemShrink>
              <S_FaviconStack></S_FaviconStack>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                The 2022 Community-a-thon has begun!
              </a>
            </S_ItemWord>
          </S_SideItem>
          <S_SideItem>
            <S_ItemShrink>
              <S_FaviconStack></S_FaviconStack>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                Mobile app infrastructure being decommissioned
              </a>
            </S_ItemWord>
          </S_SideItem>
          <S_SideItem>
            <S_ItemShrink>
              <S_FaviconStack className="flow"></S_FaviconStack>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                Staging Ground Workflow: Canned Comments
              </a>
            </S_ItemWord>
          </S_SideItem>
          <S_SideItem>
            <S_ItemShrink>
              <S_FaviconStack className="flow"></S_FaviconStack>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                The Ask Wizard (2022) has graduated
              </a>
            </S_ItemWord>
          </S_SideItem>
          <S_SideHead>Hot Meta Posts</S_SideHead>
          <S_SideItem>
            <S_ItemShrink>
              <span>10</span>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                Announcing the Content Discovery initiative
              </a>
            </S_ItemWord>
          </S_SideItem>
          <S_SideItem>
            <S_ItemShrink>
              <span>21</span>
            </S_ItemShrink>
            <S_ItemWord>
              <a href="https://stackoverflow.blog/2022/10/25/a-flight-simulator-for-developers-to-practice-real-world-challenges-and-surprises-ep-500/?cb=1">
                A/B testing: moving Related Questions higher on question pages
              </a>
            </S_ItemWord>
          </S_SideItem>
        </ul>
      </S_SideBarWidget>
      <S_SideBarWidgetReg>
        <h2>Custom Filters</h2>
        <ul>
          <li>
            <a href="/">Create a custom filter</a>
          </li>
        </ul>
      </S_SideBarWidgetReg>
      <div>
        <S_SideBarWidgetReg>
          <h2>Watched Tags </h2>
          <S_SideBarWidget_Content>
            <S_ShowAddWatch>
              <div>
                <svg
                  aria-hidden="true"
                  width="48"
                  height="48"
                  viewBox="0 0 48 48"
                >
                  <path
                    opacity=".2"
                    d="M29.22 38.1a3.4 3.4 0 0 1 4.81-4.82l8.81 8.81a3.4 3.4 0 0 1-4.81 4.81l-8.81-8.8Z"
                  ></path>
                  <path d="M18.5 5a1 1 0 1 0 0 2c.63 0 1.24.05 1.84.15a1 1 0 0 0 .32-1.98A13.6 13.6 0 0 0 18.5 5Zm7.02 1.97a1 1 0 1 0-1.04 1.7 11.5 11.5 0 0 1 5.44 8.45 1 1 0 0 0 1.98-.24 13.5 13.5 0 0 0-6.38-9.91ZM18.5 0a18.5 18.5 0 1 0 10.76 33.55c.16.57.46 1.12.9 1.57L40 44.94A3.5 3.5 0 1 0 44.94 40l-9.82-9.82c-.45-.45-1-.75-1.57-.9A18.5 18.5 0 0 0 18.5 0ZM2 18.5a16.5 16.5 0 1 1 33 0 16.5 16.5 0 0 1-33 0Zm29.58 15.2a1.5 1.5 0 1 1 2.12-2.12l9.83 9.83a1.5 1.5 0 1 1-2.12 2.12l-9.83-9.83Z"></path>
                </svg>
              </div>
              <p>Watch tags to curate your list of questions. </p>
              <a href="/">
                <svg
                  aria-hidden="true"
                  width="18"
                  height="18"
                  viewBox="0 0 18 18"
                >
                  <path d="M9.06 3C4 3 1 9 1 9s3 6 8.06 6C14 15 17 9 17 9s-3-6-7.94-6ZM9 13a4 4 0 1 1 0-8 4 4 0 0 1 0 8Zm0-2a2 2 0 0 0 2-2 2 2 0 0 0-2-2 2 2 0 0 0-2 2 2 2 0 0 0 2 2Z"></path>
                </svg>
                Watch a tag
              </a>
            </S_ShowAddWatch>
          </S_SideBarWidget_Content>
        </S_SideBarWidgetReg>
      </div>
    </S_SideBar>
  );
}

export default SideBar;
