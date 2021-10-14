package io.xventure.testing.xventurehibernatepractice.Channel.Controller;

import io.xventure.testing.xventurehibernatepractice.Channel.Service.ChannelService;
import io.xventure.testing.xventurehibernatepractice.Channel.dto.ChannelDTO;
import io.xventure.testing.xventurehibernatepractice.Doctor.dto.DoctorDTO;
import io.xventure.testing.xventurehibernatepractice.Error.ErrorSelector;
import io.xventure.testing.xventurehibernatepractice.Error.GenaricException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @PostMapping(value = "/addchannel")
    public ResponseEntity<ChannelDTO> addChannel(@RequestBody ChannelDTO channelDTO){
        ChannelDTO channelDTO1 = channelService.addChannel(channelDTO);
        if(channelDTO1==null){
            throw new GenaricException(ErrorSelector.DOCTOR_NOT_FOUND);
        }else{
            return new ResponseEntity<>(channelDTO1,HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getchannel/{id}")
    public ResponseEntity<ChannelDTO> getChannelById(@PathVariable int id){
        ChannelDTO channelById = channelService.getChannelById(id);
        if(channelById==null){
            throw new GenaricException(ErrorSelector.CHANNEL_NOT_FOUND);
        }else {
            return new ResponseEntity<>(channelById,HttpStatus.OK);
        }

    }

    @GetMapping(value = "/getallchannels")
    public ResponseEntity<List<ChannelDTO>> getAllChannels(){
        List<ChannelDTO> dtos=channelService.getAllChannels();
        if(dtos.isEmpty()){
            throw new GenaricException(ErrorSelector.CHANNEL_LIST_IS_EMPTY);
        }else{
            return new ResponseEntity<>(dtos,HttpStatus.OK);
        }
    }

    @PutMapping(value = "/updatechannel/{id}")
    public ResponseEntity<ChannelDTO> updateChannel(@RequestBody ChannelDTO channelDTO,@PathVariable int id){
        ChannelDTO channelDTO1 = channelService.updateChannel(id, channelDTO);
        if(channelDTO1==null){
            throw new GenaricException(ErrorSelector.CHANNEL_NOT_FOUND);
        }else{
            return new ResponseEntity<>(channelDTO1,HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/deletechannel/{id}")
    public ResponseEntity<Boolean> deleteChannel(@PathVariable int id){
        if(!channelService.deleteChannel(id)){
            throw new GenaricException(ErrorSelector.CHANNEL_NOT_FOUND);
        }else{
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
    }
}
