alter table tracker.time_pieces
add column id uuid unique default gen_random_uuid()
;
