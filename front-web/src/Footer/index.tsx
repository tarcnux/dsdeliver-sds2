import './styles.css';

import { ReactComponent as YouTubeIcon} from './Youtube.svg';
import { ReactComponent as LinkedinIcon} from './Linkedin.svg';
import { ReactComponent as InstagramIcon} from './Instagram.svg';

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.youtube.com" target="_new">
                    <YouTubeIcon />
                </a>
                <a href="https://www.linkedin.com/in/tarcnux" target="_new">
                    <LinkedinIcon />
                </a>
                <a href="https://www.instagram.com/tarcnux" target="_new">
                    <InstagramIcon />
                </a>
            </div>
        </footer>
    )
}

export default Footer;