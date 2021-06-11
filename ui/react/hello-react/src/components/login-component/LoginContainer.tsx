import { IState } from '../../reducers';
import { loginAction } from '../../actions/login-action';
import { connect } from 'react-redux';
import LoginComponent from './LoginComponent';

export const mapStateToProps = (state: IState) => {
    return {
        authUser: state.login.authUser,
        errorMessage: state.login.errorMessage
    }
}

export const mapDispatchToProps = {
    loginAction
}

export default connect(mapStateToProps, mapDispatchToProps)(LoginComponent);