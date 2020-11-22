import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import Grid from '@material-ui/core/Grid';
import Dialog from '@material-ui/core/Dialog';
import MuiDialogTitle from '@material-ui/core/DialogTitle';
import MuiDialogContent from '@material-ui/core/DialogContent';
import { withStyles } from '@material-ui/core/styles';
import CloseIcon from '@material-ui/icons/Close';
import DialogActions from '@material-ui/core/DialogActions';

const styles = (theme) => ({
    root: {
        margin: 0,
        padding: theme.spacing(2),
    },
    closeButton: {
        position: 'absolute',
        right: theme.spacing(1),
        top: theme.spacing(1),
        color: theme.palette.grey[500],
    },
});

const DialogTitle = withStyles(styles)((props) => {
    const { children, classes, onClose, ...other } = props;
    return (
        <MuiDialogTitle disableTypography className={classes.root} {...other}>
            <Typography variant="h6">{children}</Typography>
            {onClose ? (
                <IconButton aria-label="close" className={classes.closeButton} onClick={onClose} style={{ outline: 0}}>
                    <CloseIcon />
                </IconButton>
            ) : null}
        </MuiDialogTitle>
    );
});

const DialogContent = withStyles((theme) => ({
    root: {
        padding: theme.spacing(2),
    },
}))(MuiDialogContent);

export default function CourseCard(props) {

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
    };

    return (
        <Card elevation={2} id='sc' style={{ width: '200px', height: '100px', cursor: "grab"}}>
            

            <div style={{ display: 'flex', justifyContent: 'space-between' }}>
                <CardContent >
                    <Grid container direction='column' justify='center'>
                        <Grid container alignItems='center'>
                            <Typography style={{ fontSize: 15, fontWeight: "bold" }}>{props.courseCode}</Typography>
                            <Typography style={{ fontSize: 10, color: '#7f7f7f' }}> - {props.section}</Typography>
                        </Grid>
                        <Grid item>
                            <Typography style={{ fontSize: 10, color: '#7f7f7f' }}>{props.time}, {props.day}</Typography>
                        </Grid>
                        <Grid item>
                            <Typography style={{ fontSize: 10, color: '#7f7f7f' }}>{props.professor}</Typography>
                        </Grid>
                        <Grid item>
                            <Typography style={{ fontSize: 13, color: '#7f7f7f' }}>{props.credits} credits</Typography>
                        </Grid>
                    </Grid>
                </CardContent>
                <div>
                    <IconButton onClick={handleClickOpen} style={{ outline: 0 }}>
                        <ErrorOutlineIcon style={{ width: '15px', height: '15px' }}></ErrorOutlineIcon>
                    </IconButton>
                    <Typography style={{ fontSize: 13, color: '#7f7f7f', position: 'relative', top: '33px', left: '5px' }}>
                        {props.population}/{props.capacity}
                    </Typography>
                    <Dialog style={{ padding: '10px' }} onClose={handleClose} aria-labelledby="customized-dialog-title" open={open}>
                        <DialogTitle id="customized-dialog-title" onClose={handleClose}>
                            {props.courseName}
                        </DialogTitle>
                        <DialogContent dividers style={{ width: '600px', height: '300px' }}>
                            <Grid container justify="space-evenly">

                                <Grid container direction="column" justify="space-evenly" alignItems="center">
                                    <Grid item>
                                        <Typography style={{ float: 'left' }}>Available on: {props.availability} semester</Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography style={{ float: 'left' }}>Pre-requisites: N/A </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography style={{ float: 'left' }}>Co-requisites: N/A </Typography>
                                    </Grid>

                                </Grid>
                                <Grid container justify="flex-start">
                                    <Grid item>
                                        <Typography style={{ float: 'left', padding: '10px' }}>Description: {props.description}</Typography>
                                    </Grid>
                                </Grid>
                            </Grid>
                        </DialogContent>
                    </Dialog>
                </div>
                <div style={{ backgroundColor: props.color, width: '10%', height: '150px' }} />
            </div>

        </Card>
    );

}
