import { EarthSvg, InfoSvg, StarSvg } from '../../../assets/images/HomeSvg';
import { DropdownContainer, Wrapper, Teams } from './Dropdown_style';

export const Dropdown = (type) => {
  return (
    <DropdownContainer>
      <Wrapper>
        <div className="side-bar-tabs">
          <div className="tab-menu">
            <div>Home</div>
          </div>
          <p className="title">PUBLIC</p>
          <a href="/" className={type.page2 === 'home' ? 'selected' : ''}>
            <p>
              <EarthSvg />
              Questions
            </p>
          </a>
          <a href="/tags" className={type.page2 === 'tags' ? 'selected' : ''}>
            <p className="is-padding">Tags</p>
          </a>
          <a href="/users" className={type.page2 === 'users' ? 'selected' : ''}>
            <p className="is-padding">Users</p>
          </a>
          <div className="tab-menu">
            <div className="companies">Companies</div>
          </div>
          <div className="collectives">
            COLLECTIVES
            <InfoSvg />
          </div>
        </div>

        <div className="tab-menu2">
          <StarSvg />
          Explore Collectives
        </div>
        <div className="teams">TEAMS</div>
        <Teams>
          <div className="textbox">
            <strong>Stack Overflow for Teams -</strong>
            Start collaborating and sharing organizational knowledge.
          </div>
          <img
            src="https://cdn.sstatic.net/Img/teams/teams-illo-free-sidebar-promo.svg?v=47faa659a05e"
            width="139"
            height="114"
            alt="promo"
          />
          <button className="orange-button">Create a free Team</button>
          <button className="white-button">Why Teams?</button>
        </Teams>
      </Wrapper>
    </DropdownContainer>
  );
};
