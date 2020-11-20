import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import ErrorOutlineIcon from '@material-ui/icons/ErrorOutline';
import Grid from '@material-ui/core/Grid';

export default function SectionCard(props) {

    return (
        <Card elevation={2} style={{ width: '200px', height: '100px' }}>

            <div style={{ display: 'flex', justifyContent: 'space-between' }}>
                <CardContent >
                    <Grid container direction='column' justify='center'>
                        <Grid container alignItems='center'>
                            <Typography style={{ fontSize: 15, fontWeight: "bold" }}>{props.courseCode}</Typography>
                            <Typography style={{ fontSize: 10, color: '#7f7f7f' }}> - {props.section}</Typography>
                        </Grid>
                        <Grid item>
                            <Typography style={{ fontSize: 12, color: '#7f7f7f' }}>{props.courseName}</Typography>
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
                    <IconButton aria-label="delete">
                        <ErrorOutlineIcon style={{ width: 15, height: 15 }} />
                    </IconButton>
                </div>
                <div style={{ backgroundColor: props.color, width: '10%', height: '150px' }} />
            </div>

        </Card>
    );

}

{/* <Typography>
    <Table>
        <TableRow style={{ position: "relative", bottom: 10, right: 5, lineHeight: 1 }}>
            <span style={{ fontSize: 18, fontWeight: "bold" }}>{props.courseCode}</span>
            <span style={{ fontSize: 10, color: '#7f7f7f', position: "relative", bottom: 4 }}> - {props.section}</span>
            <br />
            <span style={{ fontSize: 12, color: '#7f7f7f' }}>{props.courseName}</span>
            <br />
            <span style={{ fontSize: 9, color: '#7f7f7f' }}>{props.professor}</span>
            <br />
            <span style={{ fontSize: 13, color: '#7f7f7f' }}>{props.credits} credits</span>
        </TableRow>
        <TableRow >
            <IconButton aria-label="delete" style={{ positon: "relative", width: 10, height: 10, bottom: 25, left: 80 }}>
                <ErrorOutlineIcon style={{ width: 15, height: 15 }} />
            </IconButton>
        </TableRow>
    </Table>
</Typography> */}