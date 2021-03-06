import { AppBar, List, ListItem, ListItemText, makeStyles, Toolbar, Typography } from "@material-ui/core";
import { Link } from "react-router-dom";
import { User } from "../../models/user";

interface INavbarProps {
    currentUser: User | undefined,
    // setCurrentUser: (nextCurrentUser: User | undefined) => void
}

const useStyles = makeStyles({
    link: {
        textDecoration: "none",
        color: "white"
    }
})

function NavbarComponent(props: INavbarProps) {

    const classes = useStyles();

    function logout() {
        // props.setCurrentUser(undefined);
    }

    return (
        <>
            <AppBar color="primary" position="static">
                <Toolbar>
                    <Typography variant="h5" color="inherit">
                        <List component="nav">
                            <ListItem component="div">
                                <Typography color="inherit" variant="h5">Quizzard</Typography>
                                {
                                    props.currentUser
                                        ?
                                        <>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6">
                                                    <Link to="/" className={classes.link}>Home</Link>
                                                </Typography>
                                            </ListItemText>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6" onClick={logout}>Logout</Typography>
                                            </ListItemText>
                                        </>
                                        :
                                        <>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6">
                                                    <Link to="/login" className={classes.link}>Login</Link>
                                                </Typography>
                                            </ListItemText>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6">
                                                    <Link to="/register" className={classes.link}>Register</Link>
                                                </Typography>
                                            </ListItemText>
                                        </>
                                }
                            </ListItem>
                        </List>
                    </Typography>
                </Toolbar>
            </AppBar>
        </>
    )
}

export default NavbarComponent;